package com.GooberGunter.GrandSorcery.common.items;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.item.Item;

public class ItemCrystalFragment extends Item{
	
	public ItemCrystalFragment(String regName) {
		super();
		this.setRegistryName(regName);
		this.setUnlocalizedName(GSReferences.MODID+"."+regName);
		
	}
}
