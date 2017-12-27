package com.GooberGunter.GrandSorcery.common.events;

import java.util.Random;

import com.GooberGunter.GrandSorcery.GrandSorcery;
import com.GooberGunter.GrandSorcery.api.arcana.Arcana;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaGeneration;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaProvider;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaStorage;
import com.GooberGunter.GrandSorcery.api.arcana.BiomeArcana;
import com.GooberGunter.GrandSorcery.api.arcana.IArcana;
import com.GooberGunter.GrandSorcery.common.items.ItemArcanometer;
import com.GooberGunter.GrandSorcery.common.items.ModItems;
import com.GooberGunter.GrandSorcery.common.networking.packets.ElementMessage;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.ChunkEvent.Load;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.event.world.WorldEvent.Unload;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;

@EventBusSubscriber
public class EventHandler {
	
	@SubscribeEvent
	public static void onChunkLoad(Load e) {
		if(!e.getWorld().isRemote) {
			Chunk chunk = e.getChunk();
			ArcanaGeneration gen = new ArcanaGeneration();
			chunk.markDirty();
			chunk.getCapability(ArcanaProvider.ARCANA_CAP, null);//fetches the capability on load
			IArcana arcana = chunk.getCapability(ArcanaProvider.ARCANA_CAP, null);
			int[] elements = {0,0,0,0,0};
			
			//return it
			if(arcana.getArcana()[0]==0 && arcana.getArcana()[1]==0 && arcana.getArcana()[2]==0 && arcana.getArcana()[3]==0 && arcana.getArcana()[4]==0) {
				
				//load elements up
				elements=BiomeArcana.getArcana(e.getChunk().getBiome(new BlockPos(chunk.x, gen.checkSurface(chunk, chunk.x, chunk.z), chunk.z), e.getWorld().getBiomeProvider()));
				
				
				//finalize elements
				elements[0]+=gen.addFire(chunk);
				elements[1]+=gen.addAir(chunk);
				elements[2]+=gen.addEarth(chunk);
				elements[3]+=gen.addWater(chunk);
				//avg
				elements[4]= (int) Math.sqrt(elements[0]+elements[1]+elements[2]+elements[3]);
				arcana.set(elements);
			}//if the chunk has no elements, it sets it
			if(chunk==DimensionManager.getWorld(0).getChunkFromChunkCoords(0, 0))
				Util.logger.info("Elements: "+elements[0]+" "+elements[1]+" "+elements[2]+" "+elements[3]+" "+elements[4]);
		}
		/**Chunk chunk = e.getChunk();
			chunk.markDirty();
			chunk.getCapability(ArcanaProvider.ARCANA_CAP, null);
			IArcana arcana = chunk.getCapability(ArcanaProvider.ARCANA_CAP, null);
				int[] none = {0,0,0,0,0};
				int[] test = arcana.getArcana();
				int f=test[0];
				int a=test[1];
				int ea=test[2];
				int w=test[3];
				int ar=test[4];
				
				//Util.logger.info("FOUND "+f+" "+a+" "+ea+" "+w+" "+ar);
				
				if (test[0]==0 && test[1]==0 && test[2]==0 && test[3]==0 && test[4]==0){
					Random r = new Random();
					int f1=r.nextInt(20);
					int a1=r.nextInt(20);
					int ea1=r.nextInt(20);
					int w1=r.nextInt(20);
					//Util.logger.info("REASSIGNING");
					int[] elements = {f1,a1,ea1,w1,(int) Math.sqrt(f1+a1+ea1+w1)};
					arcana.set(elements);
					//Util.logger.info("assigned fire "+ arcana.getArcana());
					//arcana.logElements();
				}
				**/
	
	}
	
	@SubscribeEvent
	public static void onWorldTick(PlayerTickEvent e) {
		Chunk chunk = new Chunk(e.player.getEntityWorld(), e.player.chunkCoordX, e.player.chunkCoordZ);
		chunk.getCapability(ArcanaProvider.ARCANA_CAP, null);
		IArcana arcana = chunk.getCapability(ArcanaProvider.ARCANA_CAP, null);
		int[] maxboi = arcana.getMax();
		int[] currentboi = arcana.getArcana();
		int[] newboi = {0,0,0,0,0};
		for(int i : arcana.getArcana()) {
			if(currentboi[i] < maxboi[i]) {
				//then regenerate
				newboi[i]=5*(1-(currentboi[i]/maxboi[i]));
			}
		}
		arcana.generate(newboi);
	}

}
