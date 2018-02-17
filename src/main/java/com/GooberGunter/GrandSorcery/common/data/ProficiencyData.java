package com.GooberGunter.GrandSorcery.common.data;

import java.util.Random;

public class ProficiencyData {
	
	private static Random r = new Random();
	
	
	public static int getPrimaryInt() {
		float chance = ((r.nextInt(100)+1)/100);
		if(chance>.70f && chance<.98f) {
			return r.nextBoolean() == true ? 7 : 8;
		}else if(chance>.98f){
			return r.nextBoolean() == true ? 9 : 10;
		}else {
			int basic = r.nextInt(5)+1;
			return basic;
		}
		
	}
	
	public static int getSecondaryInt(int prim) {
		float chance = ((r.nextInt(100)+1)/100);
		int val;
		if(chance>.80f && chance<.98f) {
			val = r.nextBoolean() == true ? 7 : 8;
		}else if(chance>.98f){
			val = r.nextBoolean() == true ? 9 : 10;
		}else {
			val = r.nextInt(5)+1;
		}
		return val == prim ? getSecondaryInt(prim) : val;
		
	}

}
