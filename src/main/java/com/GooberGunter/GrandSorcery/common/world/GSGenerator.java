package com.GooberGunter.GrandSorcery.common.world;

import java.util.Random;

import com.GooberGunter.GrandSorcery.common.block.ModBlocks;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.ChunkGeneratorEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.GenericEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GSGenerator implements IWorldGenerator{

	private WorldGenMinable crystalGen;
	
	public GSGenerator() {
		crystalGen = new WorldGenMinable(ModBlocks.crystal.getDefaultState(), 5);	
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		case 0:
			this.run(crystalGen, random, chunkX, chunkZ, world, chunkGenerator, chunkProvider, 20, 10, 1);
			break;
		case 1:
			break;
		case -1:
			break;
		}
		
	}
	//TODO Rarify
	public void run(WorldGenerator gen, Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider, int maxH, int minH, int spawnrate) {
		if(minH < 0 || maxH > 256) {
			Util.logger.info("ERROR: BAD RANGE");
			return;
		}
		int range = maxH - minH;
		for(int i =0; i<spawnrate; i++ ) {
			int x = chunkX*16 + random.nextInt(16);
			int y = minH + random.nextInt(range);
			int z = chunkZ*16 + random.nextInt(16);
			gen.generate(world, random, new BlockPos(x,y,z));
			//Util.logger.info("Crystal at: " +new BlockPos(x,y,z));
		}
		
		
	}
	
	

}
