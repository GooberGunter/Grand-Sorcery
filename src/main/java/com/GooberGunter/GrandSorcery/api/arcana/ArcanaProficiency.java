package com.GooberGunter.GrandSorcery.api.arcana;

public class ArcanaProficiency implements IArcanaProficiency{
	
	private ArcanaType primary = null;
	private ArcanaType secondary = null;
	
	@Override
	public void setProficiency(ArcanaType type, ArcanaType type2) {
		this.primary = type;
		this.secondary = type2;
	}

	@Override
	public ArcanaType[] getProficiency() {
		ArcanaType[] set = {this.primary, this.secondary};
		return set;
	}

}
