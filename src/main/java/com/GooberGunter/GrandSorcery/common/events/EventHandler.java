package com.GooberGunter.GrandSorcery.common.events;

import java.util.Random;

import com.GooberGunter.GrandSorcery.api.arcana.ArcanaGeneration;
import com.GooberGunter.GrandSorcery.api.arcana.MagickaType;
import com.GooberGunter.GrandSorcery.api.arcana.IArcanaProficiency;
import com.GooberGunter.GrandSorcery.api.arcana.IMagicka;
import com.GooberGunter.GrandSorcery.api.arcana.MagickaProvider;
import com.GooberGunter.GrandSorcery.api.arcana.ProficiencyProvider;
import com.GooberGunter.GrandSorcery.common.data.GrandSorProgressionTier;
import com.GooberGunter.GrandSorcery.common.data.ProficiencyData;
import com.GooberGunter.GrandSorcery.common.proxy.ClientProxy;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
import net.minecraftforge.event.world.ChunkEvent.Load;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class EventHandler {
	
	@SubscribeEvent
	public static void onChunkLoad(Load e) {
		if(!e.getWorld().isRemote) {
			Chunk chunk = e.getChunk();
			ArcanaGeneration gen = new ArcanaGeneration();
			chunk.markDirty();
			chunk.getCapability(MagickaProvider.MAG_CAP, null);//fetches the capability on load
			IMagicka magicka = chunk.getCapability(MagickaProvider.MAG_CAP, null);
			Random r = new Random();
			//return it
			if(magicka.getMagicka() == 0) {
				
				magicka.set(r.nextInt(500)+1);
			}//if the chunk has no elements, it sets it
		}
	}
	
	@SubscribeEvent
	public static void onPlayerLog(PlayerLoggedInEvent e) {
		Util.logger.info("TEST?");
		EntityPlayer p = e.player;
		IArcanaProficiency profs = p.getCapability(ProficiencyProvider.PROFICIENCY_CAP, null);
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			if(profs.getProficiency()[0] == null || profs.getProficiency()[1] == null) {
				Util.logger.info("ITs on the server");			
			
				//SET PRIMARY AND SECONDARY
				int t1=ProficiencyData.getPrimaryInt();
				int t2=ProficiencyData.getSecondaryInt(t1);
				profs.setProficiency(MagickaType.getTypebyId(t1), MagickaType.getTypebyId(t2));
			}
		}
		Util.logger.info("Proficiencies: "+p.getCapability(ProficiencyProvider.PROFICIENCY_CAP, null).getProficiency()[0]+" "+p.getCapability(ProficiencyProvider.PROFICIENCY_CAP, null).getProficiency()[1]);
		
	}
	
	@SubscribeEvent
	public static void reattach(Clone e) {
		EntityPlayer p = e.getEntityPlayer();
		
		IArcanaProficiency profs = p.getCapability(ProficiencyProvider.PROFICIENCY_CAP, null);
		
		if(FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			if(profs.getProficiency()[0] == null || profs.getProficiency()[1] == null) {
				Util.logger.info("ITs on the server");			
			
				//SET PRIMARY AND SECONDARY
				int t1=ProficiencyData.getPrimaryInt();
				int t2=ProficiencyData.getSecondaryInt(t1);
				profs.setProficiency(MagickaType.getTypebyId(t1), MagickaType.getTypebyId(t2));
			}
		}
		Util.logger.info("Proficiencies: "+p.getCapability(ProficiencyProvider.PROFICIENCY_CAP, null).getProficiency()[0]+" "+p.getCapability(ProficiencyProvider.PROFICIENCY_CAP, null).getProficiency()[1]);
		
	}
	
	@SubscribeEvent
	public static void onWorldTick(WorldTickEvent e) {
		//Util.logger.info("tick");
		if(!e.world.isRemote && e.world.getWorldTime()%90==0) {
			//Util.logger.info("server");
			for(int w=0;w<DimensionManager.getWorlds().length;w++) {
				if(DimensionManager.getWorld(w) != null && DimensionManager.getWorld(w).getChunkProvider() != null && DimensionManager.getWorld(w).getChunkProvider().getLoadedChunkCount() >0) {
					for(Chunk chunk : DimensionManager.getWorld(w).getChunkProvider().getLoadedChunks()) {
						//Util.logger.info("Looking through chunks");
						IMagicka magicka = chunk.getCapability(MagickaProvider.MAG_CAP, null);
						int nm = 0;
						if(magicka.getMagicka() < magicka.getMax()) {
							nm=(int) Math.sqrt(magicka.getMagicka()*magicka.getMagicka());
							if(DimensionManager.getWorld(w).getWorldTime()%nm==0) {
								magicka.generate(1);
							}
						}
					}
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onPressed(KeyInputEvent e) {
		Util.logger.info("pressed");
		KeyBinding[] keys = ClientProxy.keyBindings;
		if(keys[0].isPressed()){
			Minecraft.getMinecraft().player.getCapability(MagickaProvider.MAG_CAP, null).generate(1);
			Util.logger.info("Magika: ");
		}
	}
	
	@SubscribeEvent
	public static void onHurt(LivingHurtEvent e) {
		if(e.getEntity() instanceof EntityPlayer) {
			Random r = new Random();
			if(r.nextInt(100)<13) {
				
			}
		}
	}
}
