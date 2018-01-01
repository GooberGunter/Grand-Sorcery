package com.GooberGunter.GrandSorcery.common.block;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.GrandSorcery;
import com.GooberGunter.GrandSorcery.client.gui.GSGuiHandler;
import com.GooberGunter.GrandSorcery.common.block.tileentities.ElementalImbuerTE;
import com.GooberGunter.GrandSorcery.common.items.ModItems;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ElementalImbuer extends Block{

	public ElementalImbuer(String registryName) {
		super(Material.ROCK);
		this.setRegistryName(registryName);
		this.setUnlocalizedName(GSReferences.MODID+"."+registryName);
		this.setHardness(2.0f);
		this.setResistance(6.0f);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(ModItems.tabGrandSor);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		Util.logger.info("new te");
		return new ElementalImbuerTE();
	}
	
	
	@Override
	 public EnumBlockRenderType getRenderType(IBlockState state)
	    {
	        return EnumBlockRenderType.MODEL;
	    }
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		ElementalImbuerTE te = (ElementalImbuerTE) worldIn.getTileEntity(pos);
		//drop inventory items
		
		super.breakBlock(worldIn, pos, state);
		
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		//TODO Display name
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote) {
			playerIn.openGui(GrandSorcery.instance, GSGuiHandler.EnchNex_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}//on server
		
		return true;
	}
}
