package com.GooberGunter.GrandSorcery.common.items;

import java.lang.ref.Reference;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.GrandSorcery;
import com.GooberGunter.GrandSorcery.client.gui.GSGuiHandler;

import it.unimi.dsi.fastutil.objects.ReferenceSet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemOldTome extends Item{
	
	public ItemOldTome(String registryName) {
		super();
		this.setUnlocalizedName(GSReferences.MODID + "."+registryName);
		this.setRegistryName(registryName);
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		// TODO Auto-generated method stub
		if(worldIn.isRemote) {
			playerIn.openGui(GrandSorcery.instance, GSGuiHandler.Tome_Gui, worldIn, (int) playerIn.posX, (int) playerIn.posY, (int) playerIn.posZ);
		}
		
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}
