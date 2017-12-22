package com.GooberGunter.GrandSorcery.api.arcana;

import java.util.Random;

import net.minecraft.world.biome.Biome;

public class BiomeArcana {
	
	public static int[] getArcana(Biome biome) {
		// TODO find a way to randomize it per instance
		int f=0;
		int a=0;
		int ea=0;
		int w=0;
		Random r = new Random();
		switch(biome.getRegistryName().toString()) {	
			case "ocean":
				f=0;
				a=r.nextInt(35)+15;
				ea=5;
				w=50;
				break;
			case "plains":
				f=r.nextInt(25);
				a=r.nextInt(25);
				ea=r.nextInt(25);
				w=r.nextInt(25);
				break;
			case "desert":
				f=r.nextInt(40)+10;
				a=r.nextInt(50);
				ea=r.nextInt(30);
				w=0;
				break;
			case "forest":
				f=r.nextInt(10);
				a=r.nextInt(40);
				ea=r.nextInt(50);
				w=r.nextInt(25);
				break;
			case "taiga":
				f=r.nextInt(10);
				a=r.nextInt(50);
				ea=r.nextInt(50);
				w=r.nextInt(20);
				break;
			case "swampland":
				f=r.nextInt(20);
				a=r.nextInt(30);
				ea=r.nextInt(40);
				w=r.nextInt(50);
				break;
			case "river":
				f=r.nextInt(10);
				a=r.nextInt(25);
				ea=r.nextInt(30);
				w=r.nextInt(25);
				break;
			case "hell":
				f=r.nextInt(100);
				a=r.nextInt(5);
				ea=r.nextInt(5);
				w=r.nextInt(5);
				break;
			case "sky":
				f=r.nextInt(20);
				a=r.nextInt(100);
				ea=r.nextInt(20);
				w=r.nextInt(15);
				break;
			case "frozen_ocean":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "frozen_river":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "ice_flats":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "ice_mountains":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "mushroom_island_shore":
				break;
			case "beaches":
				f=r.nextInt(25);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "desert_hills":
				f=r.nextInt(40);
				a=r.nextInt(30);
				ea=r.nextInt(10);
				w=r.nextInt(5);
				break;
			case "forest_hills":
				f=r.nextInt(25);
				a=r.nextInt(35);
				ea=r.nextInt(25);
				w=r.nextInt(15);
				break;
			case "taiga_hills":
				f=r.nextInt(25);
				a=r.nextInt(35);
				ea=r.nextInt(25);
				w=r.nextInt(15);
				break;
			case "smaller_extreme_hills":
				f=r.nextInt(25);
				a=r.nextInt(50);
				ea=r.nextInt(25);
				w=r.nextInt(15);
				break;
			case "jungle":
				f=r.nextInt(25);
				a=r.nextInt(35);
				ea=r.nextInt(25);
				w=r.nextInt(15);
				break;
			case "jungle_hills":
				f=r.nextInt(25);
				a=r.nextInt(35);
				ea=r.nextInt(25);
				w=r.nextInt(15);
				break;
			case "jungle_edge":
				f=r.nextInt(25);
				a=r.nextInt(35);
				ea=r.nextInt(25);
				w=r.nextInt(15);
				break;
			case "deep_ocean":
				f=0;
				a=r.nextInt(35);
				ea=0;
				w=r.nextInt(100);
				break;
			case "stone_beach":
				f=r.nextInt(10);
				a=r.nextInt(10);
				ea=r.nextInt(50);
				w=r.nextInt(35);
				break;
			case "cold_beach":
				f=0;
				a=r.nextInt(10);
				ea=r.nextInt(50);
				w=r.nextInt(35);
				break;
			case "birch_forest":
				f=r.nextInt(25);
				a=r.nextInt(35);
				ea=r.nextInt(25);
				w=r.nextInt(15);
				break;
			case "birch_forest_hills":
				f=r.nextInt(25);
				a=r.nextInt(35);
				ea=r.nextInt(25);
				w=r.nextInt(15);
				break;
			case "roofed_forest":
				f=r.nextInt(25);
				a=r.nextInt(35);
				ea=r.nextInt(25);
				w=r.nextInt(15);
				break;
			case "taiga_cold":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "taiga_cold_hills":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "redwood_taiga":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "redwood_taiga_hills":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "extreme_hills_with_trees":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "savanna_rock":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "mesa":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "savanna":
				f=r.nextInt(10);
				a=r.nextInt(15);
				ea=r.nextInt(20);
				w=r.nextInt(50);
				break;
			case "mesa_clear_rock":
				break;
			default:
				f=r.nextInt(50);
				a=r.nextInt(50);
				ea=r.nextInt(50);
				w=r.nextInt(50);
				break;
		}
		int[] elements={f,a,ea,w,(int) Math.sqrt(f*a*ea*w)};
		return elements;
	}
}
