package com.GooberGunter.GrandSorcery.api.arcana;
/*
 * Attaches our magic energy
 */

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber
public class CapabilityHandler {
	public static final ResourceLocation ARCANA_CAP = new ResourceLocation(GSReferences.MODID, "arcana");
	public static final ResourceLocation PROFICIENCY_CAP = new ResourceLocation(GSReferences.MODID, "proficiency");
	public static final ResourceLocation PROGRESSION_CAP = new ResourceLocation(GSReferences.MODID, "progression");
	
	@SubscribeEvent
	public static void attachCapability(AttachCapabilitiesEvent<Chunk> event) {
		
		event.addCapability(ARCANA_CAP, new MagickaProvider());
		
		
	}
	
	@SubscribeEvent
	public static void attachTECap(AttachCapabilitiesEvent<TileEntity> e) {
		e.addCapability(ARCANA_CAP, new MagickaProvider());
	}
	
	@SubscribeEvent
	public static void attachPlayerCapability(AttachCapabilitiesEvent<Entity> ev) {
		if(ev.getObject() instanceof EntityPlayer && FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER) {
			ev.addCapability(ARCANA_CAP, new MagickaProvider());
			ev.addCapability(PROFICIENCY_CAP, new ProficiencyProvider());
			Util.logger.info("player found");
		}
	}
	
}
