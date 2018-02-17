package com.GooberGunter.GrandSorcery.common.proxy;

import com.GooberGunter.GrandSorcery.GrandSorcery;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaProficiency;
import com.GooberGunter.GrandSorcery.api.arcana.IArcanaProficiency;
import com.GooberGunter.GrandSorcery.api.arcana.IMagicka;
import com.GooberGunter.GrandSorcery.api.arcana.Magicka;
import com.GooberGunter.GrandSorcery.api.arcana.MagickaStorage;
import com.GooberGunter.GrandSorcery.api.arcana.ProficiencyStorage;
import com.GooberGunter.GrandSorcery.api.progress.IProgress;
import com.GooberGunter.GrandSorcery.api.progress.Progress;
import com.GooberGunter.GrandSorcery.api.progress.ProgressStorage;
import com.GooberGunter.GrandSorcery.common.networking.GrandSorceryPacketHandler;
import com.GooberGunter.GrandSorcery.common.utils.Util;
import com.GooberGunter.GrandSorcery.common.world.GSGenerator;

import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		CapabilityManager.INSTANCE.register(IMagicka.class, new MagickaStorage(), Magicka.class);
		CapabilityManager.INSTANCE.register(IArcanaProficiency.class, new ProficiencyStorage(), ArcanaProficiency.class);
		CapabilityManager.INSTANCE.register(IProgress.class, new ProgressStorage(), Progress.class);
		Util.logger.info("Capability registered");

	}
	
	public void init(FMLInitializationEvent e) {
		GrandSorcery.handler = new GrandSorceryPacketHandler();
		GrandSorcery.handler.registerMessage("grandsor");
		GameRegistry.registerWorldGenerator(new GSGenerator(), 2);
		Util.logger.info("proxyinit good");
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		Util.logger.info("proxypost good");
	}
	
	
	
}
