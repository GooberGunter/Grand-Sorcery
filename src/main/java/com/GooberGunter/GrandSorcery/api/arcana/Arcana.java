package com.GooberGunter.GrandSorcery.api.arcana;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.GooberGunter.GrandSorcery.common.utils.Util;

public class Arcana implements IArcana{
	
	private int fire = 0;
	private int water = 0;
	private int air = 0;
	private int earth = 0;
	private int arcana = 0;
	private int[] max= {0,0,0,0,0};
	
	
	@Override
	public void consume(ArcanaType type, int val) {
		Util.logger.info(val+" "+type+" consumed");
		switch (type) {
		case FIRE:
			fire -= val;
			break;
		case EARTH:
			earth -=val;
			break;
		case WATER:
			water -= val;
			break;
		case AIR:
			air -= val;
			break;
		case ARCANA:
			arcana -= val;
			break;
			
		default:
			Util.logger.info("Nothing was consumed");
			break;
		}
	}

	@Override
	public void generate(int[] vals) {
		// TODO add generation based on other values
		fire += vals[0];
		air += vals[1];
		earth += vals[2];
		water += vals[3];
		arcana += vals[4];
	}

	@Override
	public void set(int[] val) {
		this.fire = val[0];
		this.earth = val[1];
		this.air = val[2];
		this.water = val[3];
		this.arcana = val[4];
		max = val;
	}

	@Override
	public int[] getArcana() {
		int[] arcane = {fire, earth, air, water, arcana};
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
