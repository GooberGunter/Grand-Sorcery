package com.GooberGunter.GrandSorcery.common.proxy;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.block.ModBlocks;
import com.GooberGunter.GrandSorcery.common.items.ModItems;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * This class initializes things on the logical client
 * @author Justin
 *
 */

@EventBusSubscriber
public class ClientProxy extends CommonProxy{
	
	public ClientProxy(){
		
	}

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
		Util.logger.info("Client Ready");
	}
	
	@SubscribeEvent
	public static void registerItemRender(ModelRegistryEvent e) {
		Item[] items = {ModItems.oldTome, ModItems.arcanometer, ModItems.crystalFrag, ModItems.arcaneFocus, ModItems.enchantedInk, ModBlocks.airStItem, ModBlocks.aquaStItem, ModBlocks.earthStItem, ModBlocks.elementalImbuerItem, ModBlocks.fireStItem, ModBlocks.airBrItem, ModBlocks.aquaBrItem, ModBlocks.earthBrItem, ModBlocks.fireBrItem};
		
		for(Item item : items) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
		
		Util.logger.info("Renders Registered");
	}
	
	@SubscribeEvent
	public static void registerBlockRender(ModelRegistryEvent e) {
		Block[] blocks = {ModBlocks.elementalImbuer, ModBlocks.airStone, ModBlocks.aquaStone, ModBlocks.earthStone, ModBlocks.fireStone, ModBlocks.airBricks, ModBlocks.aquaBricks, ModBlocks.earthenBricks, ModBlocks.fireBricks};
		for(Block block : blocks) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}
		B3DLoader.INSTANCE.addDomain(GSReferences.MODID);
		OBJLoader.INSTANCE.addDomain(GSReferences.MODID);
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.crystal), 0, new ModelResourceLocation(ModBlocks.crystal.getRegistryName(), "inventory"));
	}
	
}
