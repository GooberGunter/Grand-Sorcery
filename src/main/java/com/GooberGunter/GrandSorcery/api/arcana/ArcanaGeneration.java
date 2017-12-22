package com.GooberGunter.GrandSorcery.api.arcana;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.chunk.Chunk;

public class ArcanaGeneration {
	
	public int generateFire(Chunk chunk) {
		int totFire=0;
		for(int x=0; x<16; x++) {
			for(int z=0; z<16;z++) {
				for(int y=255; y>0; y--) {
					IBlockState block = chunk.getBlockState(x, y, z);
					if(block == Blocks.LAVA) {
						totFire+=15;
					}//if there's lava, add 15
				}//runs through y
			}//runs through z
		}//runs through x
		return totFire;
	}
	
	public int checkSurface(Chunk chunk, int x, int z) {
		int y;
		for(y=255; y>0; y--) {
			if(chunk.getBlockState(x, y, z) != Blocks.AIR) {
				return y;
			}
		}
		return 0;
	}
}
