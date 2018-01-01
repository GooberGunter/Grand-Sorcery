package com.GooberGunter.GrandSorcery.common.block;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class FireStone extends Block{

	public FireStone(String registryName) {
		super(Material.ROCK);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(GSReferences.MODID+"."+registryName);
		this.setCreativeTab(ModItems.tabGrandSor);
	}

}
