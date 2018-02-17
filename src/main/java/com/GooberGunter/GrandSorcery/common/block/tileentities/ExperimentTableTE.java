package com.GooberGunter.GrandSorcery.common.block.tileentities;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ITickable;
import net.minecraftforge.items.ItemStackHandler;

public class ExperimentTableTE extends TEBase implements ITickable{
	private boolean isPpr;
	
	public ExperimentTableTE() {
		super.itemHandler = new ItemStackHandler(2);
		isPpr=false;
	}

	@Override
	public void update() {
		if(itemHandler.getStackInSlot(0).getItem()==Items.PAPER) {
			isPpr=true;
		}else {
			isPpr=false;
		}
	}
	
	public boolean getPpr() {
		return isPpr;
	}
	
}
