package com.GooberGunter.GrandSorcery.common.proxy;

import com.GooberGunter.GrandSorcery.api.arcana.Arcana;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaStorage;
import com.GooberGunter.GrandSorcery.api.arcana.IArcana;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * This class initializes things on the logical server
 * @author Justin
 *
 */

@EventBusSubscriber
public class ServerProxy extends CommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
	}

	@Override
	public void init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.init(e);
		

	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
		Util.logger.info("Server Ready");
	}
}
