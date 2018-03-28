package com.GooberGunter.GrandSorcery.api.arcana;

public class ArcanaProficiency implements IArcanaProficiency{
	
	private MagickaType primary = null;
	private MagickaType secondary = null;
	
	@Override
	public void setProficiency(MagickaType type, MagickaType type2) {
		this.primary = type;
		this.secondary = type2;
	}

	@Override
	public MagickaType[] getProficiency() {
		MagickaType[] set = {this.primary, this.secondary};
		return set;
	}

}
