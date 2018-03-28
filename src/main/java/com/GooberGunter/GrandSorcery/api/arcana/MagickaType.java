package com.GooberGunter.GrandSorcery.api.arcana;

public enum MagickaType {
	FIRE(1),
	EARTH(2),
	WATER(3),
	AIR(4),
	LIGHTNING(5),
	
	ARCANA(6),
	
	LIFE(7),
	DEATH(8),
	BLOOD(11),
	SOUL(12),
	
	LIGHT(9),
	SHADOW(10),
	PRIMORDIAL(0),//aka balance
	
	GLITCH(-1);
	
	private int id;
	
	private MagickaType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public static MagickaType getTypebyId(int id) {
		for(MagickaType e : values()) {
			if(e.getId()==id) {
				return e;
			}
		}
		return GLITCH;
	}
	
}
