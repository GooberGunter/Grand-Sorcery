package com.GooberGunter.GrandSorcery.client.gui;

import com.GooberGunter.GrandSorcery.common.block.tileentities.ElementalImbuerTE;
import com.GooberGunter.GrandSorcery.common.inventory.ContainerImbuer;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GSGuiHandler implements IGuiHandler{

	public static final int EnchNex_GUI = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == EnchNex_GUI)
			return new ContainerImbuer(player.inventory, (ElementalImbuerTE) world.getTileEntity(new BlockPos(x, y, z)));
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == EnchNex_GUI) {
			//Util.logger.info("hey der");
			return new ElementalImbuerGUI(new ContainerImbuer(player.inventory, (ElementalImbuerTE) world.getTileEntity(new BlockPos(x,y,z))));
		}
		//Util.logger.info("nada");
		return null;
	}

}
