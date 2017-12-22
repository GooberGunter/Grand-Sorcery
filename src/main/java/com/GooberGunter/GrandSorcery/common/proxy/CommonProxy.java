package com.GooberGunter.GrandSorcery.common.proxy;

import com.GooberGunter.GrandSorcery.GrandSorcery;
import com.GooberGunter.GrandSorcery.api.arcana.Arcana;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaStorage;
import com.GooberGunter.GrandSorcery.api.arcana.IArcana;
import com.GooberGunter.GrandSorcery.common.networking.GrandSorceryPacketHandler;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		CapabilityManager.INSTANCE.register(IArcana.class, new ArcanaStorage(), Arcana.class);
		Util.logger.info("Capability registered");

	}
	
	public void init(FMLInitializationEvent e) {
		GrandSorcery.handler = new GrandSorceryPacketHandler();
		GrandSorcery.handler.registerMessage("grandsor");
		Util.logger.info("proxyinit good");
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		Util.logger.info("proxypost good");
	}
	
	
	
}
