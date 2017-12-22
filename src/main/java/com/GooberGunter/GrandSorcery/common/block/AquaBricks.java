package com.GooberGunter.GrandSorcery.common.block;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class AquaBricks extends Block{
	
	public AquaBricks(String regName) {
		super(Material.ROCK);
		this.setRegistryName(regName);
		this.setUnlocalizedName(GSReferences.MODID+"."+regName);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
}
