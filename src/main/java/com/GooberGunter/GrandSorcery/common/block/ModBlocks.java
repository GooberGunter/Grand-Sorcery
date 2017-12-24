package com.GooberGunter.GrandSorcery.common.block;

import com.GooberGunter.GrandSorcery.common.block.debugBlocks.ACTE;
import com.GooberGunter.GrandSorcery.common.block.debugBlocks.ArcanaConsumer;
import com.GooberGunter.GrandSorcery.common.block.tileentities.ElementalImbuerTE;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import scala.reflect.macros.internal.macroImpl;

public final class ModBlocks {
	public static Block elementalImbuer = new ElementalImbuer("elemental_imbuer");
	public static Block airStone = new AirStone("air_stone");
	public static Block aquaStone = new AquaStone("aqua_stone");
	public static Block fireStone = new FireStone("searing_stone");
	public static Block earthStone = new EarthenStone("earthen_stone");
	public static Block airBricks = new AirBricks("air_bricks");
	public static Block aquaBricks = new AquaBricks("aqua_bricks");
	public static Block fireBricks = new MagmaticBricks("magmatic_bricks");
	public static Block earthenBricks = new EarthenBricks("earthen_bricks");
	
	public static Block testBlock = new ArcanaConsumer("consumer");
	public static ItemBlock tstb = new ItemBlock(testBlock);
	
	public static ItemBlock elementalImbuerItem = new ItemBlock(elementalImbuer);
	public static ItemBlock airStItem = new ItemBlock(airStone);
	public static ItemBlock aquaStItem = new ItemBlock(aquaStone);
	public static ItemBlock fireStItem = new ItemBlock(fireStone);
	public static ItemBlock earthStItem = new ItemBlock(earthStone);
	public static ItemBlock airBrItem = new ItemBlock(airBricks);
	public static ItemBlock aquaBrItem = new ItemBlock(aquaBricks);
	public static ItemBlock fireBrItem = new ItemBlock(fireBricks);
	public static ItemBlock earthBrItem = new ItemBlock(earthenBricks);
	
	@Mod.EventBusSubscriber
	public static class BlockRegister{
		
		@SubscribeEvent
		public static void registerBlock(RegistryEvent.Register<Block> e) {
			e.getRegistry().registerAll(elementalImbuer, airStone, aquaStone, fireStone, earthStone, airBricks, aquaBricks, fireBricks, earthenBricks, testBlock);
			elementalImbuerItem.setRegistryName(elementalImbuer.getRegistryName());
			airStItem.setRegistryName(airStone.getRegistryName());
			aquaStItem.setRegistryName(aquaStone.getRegistryName());
			fireStItem.setRegistryName(fireStone.getRegistryName());
			earthStItem.setRegistryName(earthStone.getRegistryName());
			airBrItem.setRegistryName(airBricks.getRegistryName());
			aquaBrItem.setRegistryName(aquaBricks.getRegistryName());
			fireBrItem.setRegistryName(fireBricks.getRegistryName());
			earthBrItem.setRegistryName(earthenBricks.getRegistryName());
			
			tstb.setRegistryName(testBlock.getRegistryName());
			
			GameRegistry.registerTileEntity(ElementalImbuerTE.class, "elemental_enchanter_te");
			GameRegistry.registerTileEntity(ACTE.class, "consumer_te");
			Util.logger.info("BLOCKS REGISTERED");
		}
	}
}
