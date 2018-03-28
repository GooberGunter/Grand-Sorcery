package com.GooberGunter.GrandSorcery.common.data.player;

import java.util.List;

import com.GooberGunter.GrandSorcery.common.magicka.spells.SpellBase;

public class PlayerMagickaData implements IPlayerMagickaData{
	
	private int level;
	private int xp;
	private int mlv;
	private SpellBase lSpell;
	private SpellBase rSpell;
	private List<SpellBase> list;
	
	@Override
	public void setLvl(int l) {
		this.level=l;
	}

	@Override
	public void setXp(int xp) {
		this.xp=xp;
	}

	@Override
	public void setMLv(int l) {
		this.mlv=l;
	}

	@Override
	public int getLvl() {
		return this.level;
	}

	@Override
	public int getXp() {
		return this.xp;
	}

	@Override
	public int getMLv() {
		return this.level-this.mlv;
	}

	@Override
	public void setLSpell(SpellBase l) {
		this.lSpell=l;
	}

	@Override
	public void setRSpell(SpellBase r) {
		this.rSpell=r;
	}

	@Override
	public SpellBase getLSpell() {
		return this.lSpell;
	}

	@Override
	public SpellBase getRSpell() {
		return this.rSpell;
	}

	@Override
	public void setSpellList(List<SpellBase> list) {
		this.list=list;
	}

	@Override
	public void addSpell(SpellBase spell) {
		this.list.add(spell);
	}

	@Override
	public List<SpellBase> getSpellList() {
		return this.list;
	}

}
