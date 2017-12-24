package com.GooberGunter.GrandSorcery.api.arcana;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.GooberGunter.GrandSorcery.common.utils.Util;

public class Arcana implements IArcana{
	
	private int fire = 0;
	private int water = 0;
	private int air = 0;
	private int earth = 0;
	private int arcana = 0;
	private int life = 0;
	private int death = 0;
	private int light = 0;
	private int shadow = 0;
	private int[] max= {0,0,0,0,0,0,0};
	
	
	@Override
	public void consume(ArcanaType type, int val) {
		Util.logger.info(val+" "+type+" consumed");
		switch (type) {
		case FIRE:
			if(this.fire<=0) 
				this.fire=0;
			this.fire -= val;
			break;
		case EARTH:
			if(this.earth<=0) 
				this.earth=0;
			this.earth -=val;
			break;
		case WATER:
			if(this.water<=0) 
				this.water=0;
			this.water -= val;
			break;
		case AIR:
			if(this.air<=0) 
				this.air=0;
			this.air -= val;
			break;
		case ARCANA:
			if(this.arcana<=0) 
				this.arcana=0;
			this.arcana -= val;
			break;
		case LIFE:
			if(this.life<=0) 
				this.life=0;
			this.life -= val;
			break;
		case DEATH:
			if(this.death<=0) 
				this.death=0;
			this.death -= val;
			break;
		case LIGHT:
			if(this.light<=0) 
				this.light=0;
			this.light -= val;
			break;
		case SHADOW:
			if(this.shadow<=0) 
				this.shadow=0;
			shadow -= val;
			break;
		default:
			Util.logger.info("Nothing was consumed");
			break;
		}
	}

	@Override
	public void generate(int[] vals) {
		// TODO add generation based on other values
		this.fire += vals[0];
		this.air += vals[1];
		this.earth += vals[2];
		this.water += vals[3];
		this.arcana += vals[4];
		
	}

	@Override
	public void set(int[] val) {
		this.fire = val[0];
		this.air = val[1];
		this.earth = val[2];
		this.water = val[3];
		this.arcana = val[4];
		this.death = (val[0]/2)+(val[1]/4);
		this.life = (3*val[3]/4)+(val[1]/2);
		this.light = (3*this.life/4);
		this.shadow = (3*this.death/4);
		max = val;
	}

	@Override
	public int[] getArcana() {
		int[] arcane = {this.fire, this.earth, this.air, this.water, this.arcana, this.life, this.death, this.light, this.shadow};
		return arcane;
	}
	
	
	public void logElements() {
		int i=this.fire;
		int j=this.air;
		int k=this.earth;
		int l=this.water;
		int m=this.arcana;
		Util.logger.info("fire: "+i+" air: "+j+" earth: "+k+" water: "+l+" arcana: "+m);
		
	}
	
	@Override
	public int[] getMax() {
		return max;
	}

}
