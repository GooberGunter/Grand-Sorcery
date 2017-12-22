package com.GooberGunter.GrandSorcery.common.block;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class AirBricks extends Block{
	
	public AirBricks(String registryName) {
		super(Material.ROCK);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(GSReferences.MODID+"."+registryName);
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
