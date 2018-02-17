package com.GooberGunter.GrandSorcery.common.inventory;

import com.GooberGunter.GrandSorcery.common.block.tileentities.TEBase;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBase extends Container{

	public TEBase te;
	private int sloty;
	private int slotx;
	/**
	 * 
	 * @param playerInv: Player Inventory
	 * @param te: Tile entity
	 * @param x1: x position of the slot
	 * @param y1: y position of the slot
	 * @param xloc: 
	 * @param yloc
	 * @param height
	 * @param width
	 */
	public ContainerBase(IInventory playerInv, TEBase te, int x1, int y1, int xloc, int yloc, int width, int height) {
		this.te = te;
		Util.logger.info("tileboy: "+te);
		this.slotx=x1;
		this.sloty=y1;
		
		/**SLOT SETTER**/
		this.addSlot(xloc, yloc);
		
		//player inventory, slots 9-35, slot ids: 1-27
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 74 + x * 18, height-3-(3*18) + y * 18));
			}
		}
				
		//player action bar, slots 0-8, slot ids: 28-36
		for(int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(playerInv, x, 74 + x * 18, height));
		}
		Util.logger.info("slots added");
		
	}
	public ContainerBase(IInventory playerInv, TEBase te, int x1, int y1, int height, int width) {
		this(playerInv, te, x1, y1, 0, 0, height, width);
		Util.logger.info("intertile: "+te);

	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		Util.logger.info("transfer");
		ItemStack previous = ItemStack.EMPTY;
	    Slot slot = (Slot) this.inventorySlots.get(index);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        //previous = current.copy();

	        if (index < 1) {
	            // From TE Inventory to Player Inventory
	            if (!this.mergeItemStack(current, 1, 37, true))
	                return ItemStack.EMPTY;
	        } else {
	            // From Player Inventory to TE Inventory
	            if (!this.mergeItemStack(current, 0, this.slotx+this.sloty+1, false))
	                return ItemStack.EMPTY;
	        }
	        
	        if (current.getCount() == 0)
	            slot.putStack(ItemStack.EMPTY);
	        else
	            slot.onSlotChanged();

	        if (current.getCount() == previous.getCount())
	            return ItemStack.EMPTY;
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}
	
	public void addSlot(int xloc, int yloc) {
		for(int y=0;y<this.sloty;y++) {
			for(int x=0;x<this.slotx;x++) {
				this.addSlotToContainer(new SlotItemHandler(te.getItemHandler(), x+y*x, xloc + x*18, yloc + y*18));
			}
		}
	}
	
}
