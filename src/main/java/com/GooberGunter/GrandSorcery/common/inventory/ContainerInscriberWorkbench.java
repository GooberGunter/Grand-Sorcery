package com.GooberGunter.GrandSorcery.common.inventory;

import com.GooberGunter.GrandSorcery.common.block.tileentities.ExperimentTableTE;
import com.GooberGunter.GrandSorcery.common.block.tileentities.TEBase;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerInscriberWorkbench extends ContainerBase{
	
	public ContainerInscriberWorkbench(IInventory playerInv, ExperimentTableTE te) {
		super(playerInv, te, 2, 2, 304, 221);
		//Util.logger.info("wkbnch: "+te);
	}
	
	
	@Override
	public void addSlot(int xloc, int yloc) {
		//Util.logger.info("fuck "+super.te.getItemHandler());
		this.addSlotToContainer(new SlotItemHandler(super.te.getItemHandler(), 0, 16, 14));
		this.addSlotToContainer(new SlotItemHandler(super.te.getItemHandler(), 1, 274, 14));
	}
}
