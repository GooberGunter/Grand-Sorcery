package com.GooberGunter.GrandSorcery.common.items;

import java.rmi.registry.Registry;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.block.ModBlocks;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class ModItems {
	
	public static Item oldTome = new ItemOldTome("old_tome");
	public static Item arcanometer = new ItemArcanometer("arcanometer");
	
	@Mod.EventBusSubscriber
	public static class ItemRegister{
		
		@SubscribeEvent
	    public static void registerItem(RegistryEvent.Register<Item> e) {
	    	e.getRegistry().registerAll(oldTome, arcanometer, ModBlocks.elementalImbuerItem, ModBlocks.airStItem, ModBlocks.aquaStItem, ModBlocks.fireStItem, ModBlocks.earthStItem, ModBlocks.airBrItem, ModBlocks.aquaBrItem, ModBlocks.fireBrItem, ModBlocks.earthBrItem);
	    	Util.logger.info("ITEMS REGISTERED");
	    }//subscribedevents MUST BE REGISTERED IN STATIC FIELDS
	}
}
