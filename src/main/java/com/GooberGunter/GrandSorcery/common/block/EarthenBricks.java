package com.GooberGunter.GrandSorcery.common.block;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class EarthenBricks extends Block{

	public EarthenBricks(String regName) {
		super(Material.ROCK);
		this.setRegistryName(regName);
		this.setUnlocalizedName(GSReferences.MODID+"."+regName);
		// TODO Auto-generated constructor stub
	}

}
