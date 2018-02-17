package com.GooberGunter.GrandSorcery.api.arcana;

public enum ArcanaType {
	FIRE(1),
	EARTH(2),
	WATER(3),
	AIR(4),
	LIGHTNING(5),
	ARCANA(6),
	LIFE(7),
	DEATH(8),
	LIGHT(9),
	SHADOW(10),
	PRIMORDIAL(0),
	GLITCH(-1);//aka balance
	
	private int id;
	
	private ArcanaType(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public static ArcanaType getTypebyId(int id) {
		for(ArcanaType e : values()) {
			if(e.getId()==id) {
				return e;
			}
		}
		return GLITCH;
	}
	
}
