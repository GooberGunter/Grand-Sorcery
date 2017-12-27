package com.GooberGunter.GrandSorcery.client.gui;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class TomeGui extends GuiScreen{
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/old_tome.png"));
		this.drawModalRectWithCustomSizedTexture((width/2)-100, (height/2)-100, 200, 200, 200, 200, 200, 200);
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	
	
	
}
