package com.GooberGunter.GrandSorcery.api.arcana;
/*
 * Attaches our magic energy
 */

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class CapabilityHandler {
	public static final ResourceLocation ARCANA_CAP = new ResourceLocation(GSReferences.MODID, "arcana");
	
	@SubscribeEvent
	public static void attachCapability(AttachCapabilitiesEvent<Chunk> event) {
		
		event.addCapability(ARCANA_CAP, new ArcanaProvider());
		
		//Util.logger.info("Attached");
	}
	
	@SubscribeEvent
	public static void attachTECap(AttachCapabilitiesEvent<TileEntity> e) {
		e.addCapability(ARCANA_CAP, new ArcanaProvider());
	}
}
