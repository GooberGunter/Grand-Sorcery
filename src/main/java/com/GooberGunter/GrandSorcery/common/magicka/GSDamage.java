package com.GooberGunter.GrandSorcery.common.magicka;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class GSDamage extends DamageSource{

	public static DamageSource FLAME = new GSDamage("flame").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource WATER = new GSDamage("water").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource EARTH = new GSDamage("earth").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource AIR = new GSDamage("air").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource LIGHTNING = new GSDamage("lightning").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource LIFE = new GSDamage("life").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource DEATH = new GSDamage("death").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource ARCANA = new GSDamage("arcana").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource LIGHT = new GSDamage("light").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource SHADOW = new GSDamage("shadow").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource PRIMORDIAL = new GSDamage("primodial").setDamageBypassesArmor().setMagicDamage();
	
	public static DamageSource[] $VALUES = new DamageSource[] {FLAME, WATER, EARTH, AIR, LIGHTNING, LIFE, DEATH, ARCANA, LIGHT, SHADOW, PRIMORDIAL};
	
	public GSDamage(String damageTypeIn) {
		super(damageTypeIn);
	}
	
	public static DamageSource causeIndirectMagicDamage(DamageSource type, Entity source, Entity target) {
		return new EntityDamageSourceIndirect(type.damageType, source, target);
	}
	
	public static DamageSource[] values() {
		return $VALUES.clone();
	}

}
