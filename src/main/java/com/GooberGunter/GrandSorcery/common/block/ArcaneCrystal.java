package com.GooberGunter.GrandSorcery.common.block;

import java.util.Random;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.items.ItemCrystalFragment;
import com.GooberGunter.GrandSorcery.common.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.Properties;

public class ArcaneCrystal extends Block{

	public static final AxisAlignedBB NEW_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
	private long tickOrigin;
	
	public ArcaneCrystal(String RegName) {
		super(Material.GLASS);
		this.setRegistryName(RegName);
		this.setUnlocalizedName(GSReferences.MODID+"."+RegName);
		this.setHarvestLevel("gold", 0);
		this.setHardness(3);
		this.setResistance(30);
		this.setSoundType(SoundType.GLASS);
		this.setLightLevel(20);
		
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		this.tickOrigin = DimensionManager.getWorld(0).getTotalWorldTime();
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return NEW_AABB;
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
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		//TODO check if it is being mined by a gold pickaxe
		return ModItems.crystalFrag;
	}
	
	
	
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		super.randomDisplayTick(stateIn, worldIn, pos, rand);
		
		if((this.tickOrigin-DimensionManager.getWorld(0).getTotalWorldTime())%20==0)
			worldIn.spawnParticle(EnumParticleTypes.ENCHANTMENT_TABLE, pos.getX()+rand.nextDouble(), pos.getY()+rand.nextDouble(), pos.getZ()+rand.nextDouble(), 0, 0, 0);
			
	}

}
