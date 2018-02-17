package com.GooberGunter.GrandSorcery.common.data;

public enum GrandSorProgressionTier {
	DISCOVERER(1),
	ALCHEMIST(2),
	ARTIFICER(3),
	RITUALIST(4),
	MAGUS(5),
	KAMI(6),
	;
	
	private int id;
	
	private GrandSorProgressionTier(int id) {
		this.id=id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public static GrandSorProgressionTier getTierById(int id) {
		for(GrandSorProgressionTier e : values()){
			if(e.getId() == id) {
				return e;
			}
		}
		return DISCOVERER;
	}
	

}
