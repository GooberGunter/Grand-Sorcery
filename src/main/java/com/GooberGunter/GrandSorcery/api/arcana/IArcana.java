package com.GooberGunter.GrandSorcery.api.arcana;
/*
 * Adds arcana functionality to the game
 * Suits:
 * 	consumption
 * 	generation (the less there is of each element, the faster they replenish, also dependent on the values of others, working on a x:y:z:t ratio)
 * 	set (for the different biomes etc.)
 */
public interface IArcana {
	public void consume(ArcanaType type, int val);
	public void generate(int[] vals);
	public void set(int[] val);
	public int[] getArcana();
	public void logElements();
	public int[] getMax();
}
