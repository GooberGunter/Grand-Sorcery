package com.GooberGunter.GrandSorcery.common.block;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.Properties;

public class ArcaneCrystal extends Block{

	public ArcaneCrystal(String RegName) {
		super(Material.GLASS);
		this.setRegistryName(RegName);
		this.setUnlocalizedName(GSReferences.MODID+"."+RegName);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	/**@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
		return ((IExtendedBlockState) state );
	}**/
	
	@Override
	public boolean isBlockNormalCube(IBlockState state) {
		return false;
	}

}
