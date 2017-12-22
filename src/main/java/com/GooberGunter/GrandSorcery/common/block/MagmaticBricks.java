package com.GooberGunter.GrandSorcery.common.block;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MagmaticBricks extends Block{
	
	public MagmaticBricks(String registryName) {
		super(Material.ROCK);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(GSReferences.MODID+"."+registryName);
		this.setLightLevel(100);
	}
}
