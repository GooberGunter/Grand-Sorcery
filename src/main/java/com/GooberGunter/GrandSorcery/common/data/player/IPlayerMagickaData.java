package com.GooberGunter.GrandSorcery.common.data.player;

import java.util.List;

import com.GooberGunter.GrandSorcery.common.magicka.spells.SpellBase;

public interface IPlayerMagickaData {
	public void setLvl(int l);
	public void setXp(int xp);
	public void setMLv(int l);
	public int getLvl();
	public int getXp();
	public int getMLv();
	
	public void setLSpell(SpellBase l);
	public void setRSpell(SpellBase r);
	public void setSpellList(List<SpellBase> list);
	public void addSpell(SpellBase spell);
	public SpellBase getLSpell();
	public SpellBase getRSpell();
	public List<SpellBase> getSpellList();
}
