package com.GooberGunter.GrandSorcery.client.gui;

import com.GooberGunter.GrandSorcery.GSReferences;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class ElementalImbuerGUI extends GuiContainer{

	public ElementalImbuerGUI(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/elemental_imbuer.png"));
		this.drawModalRectWithCustomSizedTexture((this.width/2)-(this.xSize/2), (this.height/2)-(this.ySize/2), this.xSize, this.ySize, this.xSize, this.ySize, this.xSize, this.ySize);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
