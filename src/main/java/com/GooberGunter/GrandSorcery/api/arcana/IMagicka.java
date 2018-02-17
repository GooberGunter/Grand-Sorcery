package com.GooberGunter.GrandSorcery.api.arcana;
/*
 * Adds arcana functionality to the game
 * Suits:
 * 	consumption
 * 	generation (the less there is of each element, the faster they replenish, also dependent on the values of others, working on a x:y:z:t ratio)
 * 	set (for the different biomes etc.)
 */
public interface IMagicka {
	public void consume(int val);
	public void generate(int val);
	public void set(int val);
	public int getMagicka();
	public int getMax();
}
