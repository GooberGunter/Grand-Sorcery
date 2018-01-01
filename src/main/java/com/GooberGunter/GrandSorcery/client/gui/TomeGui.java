package com.GooberGunter.GrandSorcery.client.gui;

import java.io.IOException;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.DimensionManager;
import scala.swing.event.MousePressed;

public class TomeGui extends GuiScreen{
	
	int x;
	int y;
	int xold;
	int yold;
	int drawx;
	int drawy;
	int lastx;
	int lasty;
	
	public TomeGui(){
		this.x=412;
		this.y=284;
		this.yold=0;
		this.xold=0;
		this.drawx=412;
		this.drawy=284;
		this.lastx=0;
		this.lasty=0;
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		this.drawBackground();
		this.drawBorders();
		
	
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	private void drawBackground() {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/tome_background.png"));
		this.drawScaledCustomSizeModalRect((width)/2-512, (height)/2-384, x, y, 1024, 1024, 1024, 768, 1024, 768);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/clouds.png"));
		//Util.logger.info("dimensions"+width+" "+height);
		this.drawModalRectWithCustomSizedTexture((width/2)-82, (height/2)-82, 1.5F*x, 1.5F*y, 465, 165, 1024, 768);
	}
	
	private void drawBorders() {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/old_tome.png"));
		this.drawModalRectWithCustomSizedTexture((width/2)-100, (height/2)-100, 0, 0, 200, 200, 200, 200);
	}
	
	@Override
	protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
		super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
		//if(this.xold-mouseX >=0 && this.xold-mouseX <=512 )
		this.x=-(mouseX-this.xold);
		//if(this.yold-mouseY >= 0 && this.yold-mouseY <= 384)
		this.y=-(mouseY-this.yold);
		Util.logger.info("mouse: "+x+" "+y);
		
	}
	
	
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		// TODO Auto-generated method stub
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.xold=mouseX+lastx;
		this.yold=mouseY+lasty;
	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		// TODO Auto-generated method stub
		super.mouseReleased(mouseX, mouseY, state);
		this.lastx=this.x;
		this.lasty=this.y;
	}
	
	
	
	
}
