package com.GooberGunter.GrandSorcery.client.gui;

import java.io.IOException;

import com.GooberGunter.GrandSorcery.client.resources.GrandResource;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.java.games.input.Keyboard;
import net.minecraft.client.gui.GuiScreen;
import scala.swing.event.KeyPressed;

public class GuiSpellPractice extends GuiScreen{
	int x;
	int y;
	int xold;
	int yold;
	int rx;
	int ry;
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.mc.getTextureManager().bindTexture(GrandResource.SPELL_PRACTICE);
		this.drawScaledCustomSizeModalRect((width/2)-100, (height/2)-100, 0, 0, 300, 300, 200, 200, 300, 300);
		this.mc.getTextureManager().bindTexture(GrandResource.WATER);
		this.drawScaledCustomSizeModalRect(width/2-82, height/2-x-14, 0, 0, 125, 125, 80+x , 80+x, 125, 125);
	}
	
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		// TODO Auto-generated method stub
		super.keyTyped(typedChar, keyCode);
		if(keyCode==org.lwjgl.input.Keyboard.KEY_W) {
			x+=1;
		}
	}
}
