package com.GooberGunter.GrandSorcery.common.events;

import java.util.Random;

import com.GooberGunter.GrandSorcery.GrandSorcery;
import com.GooberGunter.GrandSorcery.api.arcana.Arcana;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaProvider;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaStorage;
import com.GooberGunter.GrandSorcery.api.arcana.IArcana;
import com.GooberGunter.GrandSorcery.common.items.ItemArcanometer;
import com.GooberGunter.GrandSorcery.common.items.ModItems;
import com.GooberGunter.GrandSorcery.common.networking.ElementMessage;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.chunk.Chunk;
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
			Chunk chunk = e.getChunk();
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
				//TODO figure out how to have them saved
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
