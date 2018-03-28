package com.GooberGunter.GrandSorcery.common.magicka.spells;

import java.io.ObjectInputStream.GetField;

import com.GooberGunter.GrandSorcery.api.arcana.MagickaType;

import net.minecraft.entity.player.EntityPlayer;

/**
 * 3 Components:
 * 1. Spell Function
 * 2. Spell Element
 * 3. Spell Level
 * 
 * Spell values:
 * -cost
 * @author JEHan
 *
 */
public class SpellBase {
	
	private String name;
	private int level;
	private MagickaType element;
	private SpellFunction function;
	
	public SpellBase(String name, int lvl, MagickaType t, SpellFunction f) {
		this.name=name;
		this.level=lvl;
		this.element=t;
		this.function=f;
		this.function.setType(t);
		this.function.setAmp(lvl);
	}
	
	public void activate(EntityPlayer p) {
		if(getFunction() != null)
		getFunction().function(p);
	}
	
	public SpellFunction getFunction() {
		return this.function;
	}
	
	public MagickaType getElement() {
		return this.element;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLevel() {
		return this.level;
	}
}
