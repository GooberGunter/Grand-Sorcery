package com.GooberGunter.GrandSorcery.api.arcana;

import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;

public class Magicka implements IMagicka{
	
	private int magicka=0;
	private int max=0;
	
	
	@Override
	public void consume(int val) {
		if(magicka > 1)
		this.magicka-=val;
	}

	@Override
	public void generate(int val) {
		// TODO add generation based on other values
		this.magicka+=val;
		Minecraft.getMinecraft().player.getPersistentID();
	}

	@Override
	public void set(int val) {
		this.magicka=val;
		this.max=val;
	}

	@Override
	public int getMagicka() {
		return this.magicka;
	}
	
	@Override
	public int getMax() {
		return max;
	}

}
