package com.GooberGunter.GrandSorcery.common.block.tileentities;

import com.GooberGunter.GrandSorcery.api.arcana.ArcanaProvider;
import com.GooberGunter.GrandSorcery.api.arcana.IArcana;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ElementalImbuerTE extends TileEntity implements ITickable{

	private IItemHandler itemHandler;
	private int[] arcanaval=new int[5];
	
	public ElementalImbuerTE() {
		this.itemHandler = new ItemStackHandler();
		this.getCapability(ArcanaProvider.ARCANA_CAP, null);
		IArcana arcana = this.getCapability(ArcanaProvider.ARCANA_CAP, null);
		
		this.arcanaval[0] = 0;
		this.arcanaval[1] = 0;
		this.arcanaval[2] = 0;
		this.arcanaval[3] = 0;
		this.arcanaval[4] = 0;
		arcana.set(arcanaval);
		
	}
	
	public IItemHandler getItemHandler() {
		return this.itemHandler;
	}
	
	@Override
	public void update() {
		//add or take away depending on the recipe
		this.getCapability(ArcanaProvider.ARCANA_CAP, null).set(arcanaval);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
	  if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
	    return true;
	  }
	  return super.hasCapability(capability, facing);
	}
	
	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
	  if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
		  Util.logger.info("problem");
	    return (T) itemHandler;
	  }
	  return super.getCapability(capability, facing);
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		NBTTagList list = new NBTTagList();
		for(int i=0; i < itemHandler.getSlots(); i++) {
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setByte("Slot", (byte) i);
			this.itemHandler.getStackInSlot(i).writeToNBT(nbt);
			list.appendTag(nbt);
		}
		compound.setTag("Items", list);
		return super.writeToNBT(compound);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		
		NBTTagList list = compound.getTagList("Items", 10);
		
		for(int i = 0; i < itemHandler.getSlots(); i++) {
			NBTTagCompound nbt = list.getCompoundTagAt(i);
			int slot = nbt.getByte("Slot") & 255;
			ItemStack stack = new ItemStack(nbt);
			this.itemHandler.insertItem(slot, stack, false);
		}
	}

}
