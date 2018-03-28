package com.GooberGunter.GrandSorcery.common.magicka.spells;

import java.util.List;

import com.GooberGunter.GrandSorcery.api.arcana.MagickaType;
import com.GooberGunter.GrandSorcery.common.magicka.GSDamage;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.common.DimensionManager;

public enum SpellFunction {
		TELEKINETIC{
			@Override
			public void function(EntityPlayer p) {
				Vec3d l = p.getLookVec();
				AxisAlignedBB bb;
				for(int range=1; range <=50; range++) {
					bb=new AxisAlignedBB(p.posX+l.x*range, p.posY+l.y*range, p.posZ+l.z*range, 
							p.posX+l.x*range+3, p.posY+l.y*range+3, p.posZ+l.z*range+3);
					List<EntityLivingBase> list = DimensionManager.getWorld(p.dimension).getEntitiesWithinAABB(EntityLivingBase.class, bb);
					if(!list.isEmpty()) {
						for(EntityLivingBase b : list) {
							if(!b.equals(p)) {
								b.attackEntityFrom(GSDamage.causeIndirectMagicDamage(getDamage(), p, b), 2*getAmp()); 
							}
						}
					}
				}
			}
		}
	;
	private MagickaType possibleT;
	private int lvlAmp;
	
	SpellFunction(){
		
	}
	
	public void setAmp(int l) {
		this.lvlAmp=l;
	}
	
	public int getAmp() {
		return this.lvlAmp;
	}
	
	public void function(EntityPlayer p) {
		
	}
	
	public void setType(MagickaType t) {
		this.possibleT=t;
	}
	
	public DamageSource getDamage() {
		for(DamageSource t : GSDamage.values()) {
			if(t.damageType.equals(this.possibleT.name())) {
				return t;
			}
		}
		return GSDamage.ARCANA;
	}
	
}
