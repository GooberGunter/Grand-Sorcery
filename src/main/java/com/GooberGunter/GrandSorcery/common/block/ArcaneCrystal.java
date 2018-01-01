package com.GooberGunter.GrandSorcery.common.block;

import java.util.Random;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.items.ItemCrystalFragment;
import com.GooberGunter.GrandSorcery.common.items.ModItems;
import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.Properties;

public class ArcaneCrystal extends Block{

	public static final AxisAlignedBB DEFAULT = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
	public static final AxisAlignedBB NORTH = new AxisAlignedBB(0.25D, 0.25D, 0.0D, 0.75D, .75D, 1.0D);//north is negative z
	public static final AxisAlignedBB WEST = new AxisAlignedBB(0.0D, 0.25D, 0.25D, 1.0D, .75D, 0.75D);//west is negative x
	private long tickOrigin;
	private static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>() {

		@Override
		public boolean apply(EnumFacing input) {
			return true;
		}
		
	});//the predicate gives us the 6 values instead of 4 or 2
	 
	public ArcaneCrystal(String RegName) {
		super(Material.GLASS);
		this.setDefaultState(this.getDefaultState().withProperty(FACING, EnumFacing.UP));
		this.setRegistryName(RegName);
		this.setUnlocalizedName(GSReferences.MODID+"."+RegName);
		this.setHarvestLevel("gold", 0);
		this.setHardness(3);
		this.setResistance(30);
		this.setSoundType(SoundType.GLASS);
		this.setLightLevel(20);
		this.setCreativeTab(ModItems.tabGrandSor);
	}
	
	/** --------------------------------------------Block State--------------------------------------------------------**/
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, FACING);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		switch((EnumFacing)state.getValue(FACING)) {
		case UP:
			i = 1;
			break;
		case DOWN:
			i = 2;
			break;
		case NORTH:
			i= 3;
			break;
		case SOUTH:
			i = 4;
			break;
		case EAST:
			i = 5;
			break;
		case WEST:
			i = 6;
			break;
		default: 
			i = 1;
			break;
		}
		
		return i;
	}
			
	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState blockstate = this.getDefaultState();
		
		switch(meta) {
		case 1:
			blockstate = blockstate.withProperty(FACING, EnumFacing.UP);
			break;
		case 2:
			blockstate = blockstate.withProperty(FACING, EnumFacing.DOWN);
			break;
		case 3:
			blockstate = blockstate.withProperty(FACING, EnumFacing.NORTH);
			break;
		case 4:
			blockstate = blockstate.withProperty(FACING, EnumFacing.SOUTH);
			break;
		case 5:
			blockstate = blockstate.withProperty(FACING, EnumFacing.EAST);
			break;
		case 6:
			blockstate = blockstate.withProperty(FACING, EnumFacing.WEST);
			break;
			default:
				blockstate = blockstate.withProperty(FACING, EnumFacing.UP);
				break;
		}
		
		return blockstate;
	}
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		IBlockState state = this.getDefaultState();
		//NORTH
		if(world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1)).getBlock() != Blocks.AIR && world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()-1)).getBlock() != ModBlocks.crystal) {
			state =state.withProperty(FACING, EnumFacing.SOUTH);
		}
		//SOUTH
		if(world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1)).getBlock() != Blocks.AIR && world.getBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()+1)).getBlock() != ModBlocks.crystal) {
			state =state.withProperty(FACING, EnumFacing.NORTH);
		}
		//EAST
		if(world.getBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ())).getBlock() != Blocks.AIR && world.getBlockState(new BlockPos(pos.getX()+1, pos.getY(), pos.getZ())).getBlock() != ModBlocks.crystal) {
			state =state.withProperty(FACING, EnumFacing.WEST);
		}
		//WEST
		if(world.getBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ())).getBlock() != Blocks.AIR && world.getBlockState(new BlockPos(pos.getX()-1, pos.getY(), pos.getZ())).getBlock() != ModBlocks.crystal) {
			state =state.withProperty(FACING, EnumFacing.EAST);
		}
		if(world.getBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ())).getBlock() != Blocks.AIR && world.getBlockState(new BlockPos(pos.getX(), pos.getY()+1, pos.getZ())).getBlock() != ModBlocks.crystal) {
			state = state.withProperty(FACING, EnumFacing.DOWN);
		}
		return state;
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	
	/** ----------------------------------------------------------------------------------------------------**/
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		
			
		this.tickOrigin = DimensionManager.getWorld(0).getTotalWorldTime();
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if(state.getValue(FACING) == EnumFacing.NORTH || state.getValue(FACING) == EnumFacing.SOUTH)
			return NORTH;
		if(state.getValue(FACING) == EnumFacing.EAST || state.getValue(FACING) == EnumFacing.WEST)
			return WEST;
		return DEFAULT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		
		return false;
	}
	
	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer) {
		// TODO Auto-generated method stub
		return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer);
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
