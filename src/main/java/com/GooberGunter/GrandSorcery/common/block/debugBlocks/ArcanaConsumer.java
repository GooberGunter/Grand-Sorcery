package com.GooberGunter.GrandSorcery.common.block.debugBlocks;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ArcanaConsumer extends Block{

	public ArcanaConsumer(String regName) {
		super(Material.ROCK);
		this.setRegistryName(regName);
		this.setUnlocalizedName(GSReferences.MODID+"."+regName);
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		Util.logger.info("new acte");
		return new ACTE();
	}

}
