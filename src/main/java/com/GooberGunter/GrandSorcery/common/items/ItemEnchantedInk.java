package com.GooberGunter.GrandSorcery.common.items;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.item.Item;

public class ItemEnchantedInk extends Item{
	public ItemEnchantedInk(String regName) {
		this.setRegistryName(regName);
		this.setUnlocalizedName(GSReferences.MODID+"."+regName);
		this.setCreativeTab(ModItems.tabGrandSor);
	}
}
