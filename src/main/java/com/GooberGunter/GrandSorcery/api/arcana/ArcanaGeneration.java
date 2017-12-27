package com.GooberGunter.GrandSorcery.api.arcana;

import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;

public class ArcanaGeneration {
	
	/**
	 * Returns total amount of fire based on blocks in chunk
	 * @param chunk
	 * @return
	 */
	public int addFire(Chunk chunk) {
		int totFire=0;
		for(int x=0; x<16; x++) {
			for(int z=0; z<16;z++) {
				for(int y=checkSurface(chunk, x, z); y>0; y--) {
					IBlockState block = chunk.getBlockState(x, y, z);
					if(block.getBlock() == Blocks.LAVA) {
						totFire+=15;
					}//if there's lava, add 15
				}//runs through y
			}//runs through z
		}//runs through x
		
		return totFire;
	}
	
	/**
	 * Returns total amount of Air based on blocks in chunk
	 * @param chunk
	 * @return
	 */
	//TODO Correct this
	public int addAir(Chunk chunk) {
		int[] ys=new int[256];
		for(int x=0;x<16;x++) {
			for(int z=0;z<16;z++) {
				ys[(x*16)+z] =this.checkSurface(chunk, x, z);
			}
		}
		int sum=0;
		for(int i : ys) {
			sum+=ys[i];
		}
		if(chunk == DimensionManager.getWorld(0).getChunkFromChunkCoords(0, 0))
			Util.logger.info("air: "+(sum/ys.length));
		return (sum/ys.length);
	}
	
	/**
	 * Returns total amount of Earth based on blocks in chunk
	 * @param chunk
	 * @return
	 */
	public int addEarth(Chunk chunk) {
		double totEarth=0;
		for(int x=0; x<16; x++) {
			for(int z=0; z<16; z++) {
				for(int y=checkSurface(chunk, x, z); y>0; y--) {
					IBlockState block = chunk.getBlockState(x,y,z);
					if(block.getBlock() == Blocks.DIRT)
						totEarth+=(1/16);
					if(block.getBlock() == Blocks.SAND)
						totEarth+=(1/16);
					if(block.getBlock() == Blocks.STONE)
						totEarth+=(1/32);
					if(block.getBlock() == Blocks.SANDSTONE)
						totEarth+=(1/48);
					//Debug
					//if(chunk==DimensionManager.getWorld(0).getChunkFromChunkCoords(0, 0))
						//Util.logger.info("Earth Now: "+totEarth);
				}
			}
		}
		//Util.logger.info("Final: "+totEarth);
		return (int) totEarth;
	}
	
	/**
	 * Returns total water based on blocks in Chunk
	 * @param chunk
	 * @return
	 */
	public int addWater(Chunk chunk) {
		int totWater=0;
		for(int x=0;x<16;x++) {
			for(int z=0;z<16;z++) {
				for(int y=checkSurface(chunk, x, z);y>0;y--) {
					IBlockState block = chunk.getBlockState(x,y,z);
					if(block.getBlock() == Blocks.WATER) {totWater+=3;}
				}
			}
		}
		
		return totWater;
	}
	
	/**
	 * Returns the y-value of the surface block
	 * @param chunk
	 * @param x
	 * @param z
	 * @return
	 */
	public int checkSurface(Chunk chunk, int x, int z) {
		int y=0;
		for(y=255; y>0; y--) {
			if(chunk.getBlockState(x,y,z).getBlock() != Blocks.AIR) {
				return y;
			}
		}
		return y;
	}
}
