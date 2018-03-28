package com.GooberGunter.GrandSorcery.client.gui.tome;

import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.api.arcana.MagickaType;
import com.GooberGunter.GrandSorcery.client.resources.GrandResource;
import com.GooberGunter.GrandSorcery.common.data.ResearchData;
import com.GooberGunter.GrandSorcery.common.data.ResearchData.ResearchTier;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.DimensionManager;
import scala.swing.event.MousePressed;

public class TomeGui extends GuiScreen{
	
	//VARIABLES
	int x;
	int y;
	int mapx;
	int mapy;
	int xold;
	int yold;
	int releaseX;
	int releaseY;
	ResearchNode node = new ResearchNode((this.width/2)+this.mapx-8, (this.height/2)+this.mapy-8, RsPages.bookPage, new ResearchData(ResearchTier.DISCOVERY, MagickaType.AIR), GrandResource.BOOK);
	boolean mainMenu;
	ArrayList<ResearchNode> nodes = new ArrayList<ResearchNode>();
	
	
	public TomeGui(){
		this.x=280;
		this.y=160;
		this.mapx=290-x;
		this.mapy=190-y;
		this.yold=512;
		this.xold=512;
		this.releaseX=0;
		this.releaseY=0;
		this.nodes.add(node);
		this.mainMenu=true;
	}
	
	public void map(ArrayList<ResearchNode> ns) {
		for(ResearchNode n : ns) {
			ResearchNode.instance.put(n, n.getPage());
		}
	}
	
	/**DRAW METHODS **/
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.mapx=280-x;
		this.mapy=160-y;
		this.map(nodes);
		this.node.setXY((this.width/2)+this.mapx-8, (this.height/2)+this.mapy-8);
		this.drawBackground();
		this.drawMapping();
		this.drawBorders();
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	private void drawBackground() {
		if(this.mainMenu==true) {
			this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/tome/tome_background.png"));
			this.drawScaledCustomSizeModalRect((this.width/2)-130, (this.height/2)-90, x, y, 412, 384, 260, 170, 1024, 768);
		}
		
	}
	
	public void drawBorders() {
		this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/old_tome_v2.png"));
		this.drawModalRectWithCustomSizedTexture((width/2)-150, (height/2)-100, 0, 0, 300, 200, 300, 200);
	}
	
	private void drawMapping() {
		this.drawIcon(this.mapx, this.mapy, GrandResource.BOOK_ICON);
		
	}
	
	public void drawIcon(int x, int y, ResourceLocation loc) {
		if(x < 130 && x >-145 && y < 85 && y > -96) {
			this.mc.getTextureManager().bindTexture(loc);
			this.drawScaledCustomSizeModalRect((this.width/2)+x-8, (this.height/2)+y-8, 0, 0, 64, 64, 16, 16, 64, 64);
		}
	}
		
	private void drawProgLine(int x, int y) {
		
	}
	
	/**CLICK EVENTS**/
	
	@Override
	protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
		super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
		if(this.xold-mouseX >=0 && this.xold-mouseX <=(512+100) ) {
			this.x=-(mouseX-this.xold);
		}
		if(this.yold-mouseY >= 0 && this.yold-mouseY <= 404)
		this.y=-(mouseY-this.yold);
		
	}
	
		
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		
		if(this.releaseX==0) {
			this.releaseX=this.x;
		}
		if(this.releaseY==0) {
			this.releaseY=this.y;
		}
		this.xold=mouseX+releaseX;
		this.yold=mouseY+releaseY;
		
		for(ResearchNode n : nodes) {
			if(GuiEssentials.checkPoint(new Point(mouseX, mouseY), n)) {
				Util.logger.info("Clicked within point");
				this.mc.displayGuiScreen(n.instance.get(n));
			}else {
				//Util.logger.info("no success: "+mouseX+" "+mouseY+" : "+n.x+" "+n.y);
			}
		}
	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
		this.releaseX=this.x;
		this.releaseY=this.y;
	}
	
	
	/**
	 * This class is used to manage the progression of the player
	 */
	public static class GuideProgression{
		private static ResearchData data;
		
		
	}
}
