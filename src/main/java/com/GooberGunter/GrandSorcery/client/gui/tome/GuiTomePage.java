package com.GooberGunter.GrandSorcery.client.gui.tome;

import java.awt.Point;
import java.io.IOException;

import javax.annotation.Nullable;

import com.GooberGunter.GrandSorcery.client.resources.GrandResource;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiTomePage extends GuiScreen{
	
	private String text1;
	private String header;
	private ResourceLocation craftGrid;
	private boolean grid;
	
	public GuiTomePage(@Nullable String header, String text) {
			this.header=header;
			this.text1=text;
	}
	
	public GuiTomePage() {
		
	}
	
	public ResourceLocation getPic() {
		return null;
	}
	
	public void drawText(String header, String text) {
		GlStateManager.scale(1.5d, 1.5d, 1.5d);
		if(header != null) {
			
			this.fontRenderer.drawString(header, (width/3)-(this.fontRenderer.getStringWidth(header)/2)-(2*150/5), ((height/3)-70), 0);
			
		}
		GlStateManager.scale((1/1.5), (1/1.5), (1/1.5));
		String[] placeholder = text.split("%n");
		int sum=0;
		for(String s : placeholder) {
			this.fontRenderer.drawSplitString(s, (width/2)-(80)-100, (height/2)+sum-60, 160, 0);
			sum+=this.fontRenderer.getWordWrappedHeight(s, 160);
		}
	}
	
	
	public void crafting() {
		this.mc.getTextureManager().bindTexture(GrandResource.CRAFTING_GRID);
		this.drawModalRectWithCustomSizedTexture((width/2)-200, (height/2)-125, 0, 0, 150, 200, 150, 200);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.mc.getTextureManager().bindTexture(GrandResource.BOOK);
		//this.drawScaledCustomSizeModalRect(this.posx, this.posy, 0, 0, 500, 300, 400, 240, 500, 300);
		this.drawModalRectWithCustomSizedTexture((this.width/2)-200, (this.height/2)-125, 0, 0, 400, 250, 400, 250);
		this.drawText(this.header, this.text1);
		super.drawScreen(mouseX, mouseY, partialTicks);
		if(grid) {this.crafting();}
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		if(keyCode==1) {
			this.mc.displayGuiScreen(new GuiTomeDiscovery());
		}
		//super.keyTyped(typedChar, keyCode);
	}
}