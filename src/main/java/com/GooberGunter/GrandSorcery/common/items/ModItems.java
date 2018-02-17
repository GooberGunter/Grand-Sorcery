package com.GooberGunter.GrandSorcery.common.items;

import java.rmi.registry.Registry;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.block.ModBlocks;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public final class ModItems {
	
	public static CreativeTabs tabGrandSor = new CreativeTabs("grand_sorcery") {
		@Override
		public ItemStack getTabIconItem() {
			return crystalFrag.getDefaultInstance();
		}
	};
	public static Item oldTome = new ItemOldTome("old_tome");
	public static Item arcanometer = new ItemArcanometer("arcanometer");
	public static Item crystalFrag = new ItemCrystalFragment("crystal_fragment");
	public static Item arcaneFocus = new ItemArcaneFocus("arcane_focus");
	public static Item enchantedInk = new ItemEnchantedInk("enchanted_ink");
	
	@Mod.EventBusSubscriber
	public static class ItemRegister{
		
		@SubscribeEvent
	    public static void registerItem(RegistryEvent.Register<Item> e) {
	    	e.getRegistry().registerAll(oldTome, arcanometer, crystalFrag, arcaneFocus, enchantedInk, ModBlocks.elementalImbuerItem, ModBlocks.airStItem, ModBlocks.aquaStItem, ModBlocks.fireStItem, ModBlocks.earthStItem, ModBlocks.airBrItem, ModBlocks.aquaBrItem, ModBlocks.fireBrItem, ModBlocks.earthBrItem, ModBlocks.tstb, ModBlocks.crystalItem, ModBlocks.wkbnchItem);
	    	Util.logger.info("ITEMS REGISTERED");
	    }//subscribedevents MUST BE REGISTERED IN STATIC FIELDS
	}
}
