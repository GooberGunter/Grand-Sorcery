package com.GooberGunter.GrandSorcery.client.gui;

import com.GooberGunter.GrandSorcery.client.gui.tome.GuiTomeDiscovery;
import com.GooberGunter.GrandSorcery.client.gui.tome.TomeGui;
import com.GooberGunter.GrandSorcery.common.block.tileentities.ElementalImbuerTE;
import com.GooberGunter.GrandSorcery.common.block.tileentities.ExperimentTableTE;
import com.GooberGunter.GrandSorcery.common.block.tileentities.TEBase;
import com.GooberGunter.GrandSorcery.common.inventory.ContainerBase;
import com.GooberGunter.GrandSorcery.common.inventory.ContainerImbuer;
import com.GooberGunter.GrandSorcery.common.inventory.ContainerInscriberWorkbench;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GSGuiHandler implements IGuiHandler{

	public static final int EnchNex_GUI = 0;
	public static final int Tome_Gui = 1;
	public static final int Inscribe_GUI = 2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == EnchNex_GUI)
			return new ContainerImbuer(player.inventory, (ElementalImbuerTE) world.getTileEntity(new BlockPos(x, y, z)));
		if(ID == Inscribe_GUI) {
			//Util.logger.info("Data good: "+new BlockPos(x,y,z));
			
			return new ContainerInscriberWorkbench(player.inventory, (ExperimentTableTE) world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == EnchNex_GUI) {
			//Util.logger.info("hey der");
			return new ElementalImbuerGUI(new ContainerImbuer(player.inventory, (ElementalImbuerTE) world.getTileEntity(new BlockPos(x,y,z))));
		}
		if(ID == Tome_Gui) {
			return new GuiTomeDiscovery();
		}
		if(ID == Inscribe_GUI) {
			//Util.logger.info("client good");
			return new ExperimentGui(new ContainerInscriberWorkbench(player.inventory, (ExperimentTableTE) world.getTileEntity(new BlockPos(x,y,z))));
		}
		//Util.logger.info("nada");
		return null;
	}

}
