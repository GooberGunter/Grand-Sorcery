package com.GooberGunter.GrandSorcery.common.inventory;

import com.GooberGunter.GrandSorcery.common.block.tileentities.ElementalImbuerTE;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;
/**
 * Manages Inventory
 * @author Justin
 *
 */
public class ContainerImbuer extends Container{
	//TODO have it where you need to put a block in there and you have a mouse event to press the elemental icons to imbue stone, iron, and other objects to form elemental objects
	//1. put block/item in
	//2. click on button
	//3. output item
	private ElementalImbuerTE te;
	
	public ContainerImbuer(IInventory playerInv, ElementalImbuerTE te) {
		this.te = te;
		
		//Tile Entity, slot 0, Slot ID: 0
		for(int y = 0; y < 1; y++) {
			for(int x = 0; x < 1; x++) {
				this.addSlotToContainer(new SlotItemHandler(te.getItemHandler(), x+y, 80 + x * 18, 42 + y * 18));
				
			}
		}
		
		//player inventory, slots 9-35, slot ids: 1-27
		for(int y = 0; y < 3; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));
			}
		}
		
		//player action bar, slots 0-8, slot ids: 28-36
		for(int x = 0; x < 9; x++) {
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x*18, 142));
		}
		
		Util.logger.info("slots added");
		
	}//player, tile entity
	
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
	            if (!this.mergeItemStack(current, 0, 1, false))
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

}

/**
*	Things to Note:
*each inventory has its own set of slot ids
*
*
*
**/