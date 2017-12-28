package com.GooberGunter.GrandSorcery.common.items;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.item.Item;

public class ItemArcaneFocus extends Item{
	
	public ItemArcaneFocus(String regName) {
		super();
		this.setRegistryName(regName);
		this.setUnlocalizedName(GSReferences.MODID+"."+regName);

	}
}
