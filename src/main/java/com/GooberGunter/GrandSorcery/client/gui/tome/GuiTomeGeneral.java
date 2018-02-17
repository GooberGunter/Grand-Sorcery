package com.GooberGunter.GrandSorcery.client.gui.tome;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.GooberGunter.GrandSorcery.client.resources.GrandResource;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public abstract class GuiTomeGeneral extends GuiScreen{
	private int x;
	private int y;
	private int mapx;
	private int mapy;
	private int xold;
	private int yold;
	private int releaseX;
	private int releaseY;
	private ResourceLocation background = GrandResource.BOOK_BACKGROUND;
	private ResourceLocation border = GrandResource.BOOK_GUI;
	ArrayList<ResearchNode> nodes = new ArrayList<ResearchNode>();
	public Map<ResearchNode, GuiTomePage> instance = new HashMap<>();
	
	public GuiTomeGeneral() {
		this.x=280;
		this.y=160;
		this.yold=512;
		this.xold=512;
		this.releaseX=0;
		this.releaseY=0;
		//this.addNodes(sectionNodes, this.nodes);
	}
	
	public void addNodes(ResearchNode[] in, ArrayList<ResearchNode> out) {
		for(ResearchNode n : in) {
			out.add(n);
		}
	}
	
	public void mapNodes(ArrayList<ResearchNode> ns) {
		for(ResearchNode n : ns) {
			if(n != null)
				this.instance.put(n, n.getPage());
		}
	}
	
	/** DRAW METHODS **/
	
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.mapx=280-x;
		this.mapy=160-y;
		this.mapNodes(getNodes());
		this.drawBG();
		
		this.drawTree();
		
		this.drawBorders();
		
		
	}
	
	public void drawBG() {
		this.mc.getTextureManager().bindTexture(getBackground());
		this.drawScaledCustomSizeModalRect((this.width/2)-130, (this.height/2)-90, x, y, 412, 384, 260, 170, 1024, 768);
	}
	
	public void drawTree() {
		//TODO progresslines and icons
		for(ResearchNode n : getNodes()) {
			if(n.getX()>(width/2)-150 && n.getX()<(width/2)+120 && n.getY()>(height/2)-100 && n.getY()<(height/2)+70) {
				this.mc.getTextureManager().bindTexture(n.getIcon());
				this.drawModalRectWithCustomSizedTexture((int) n.getX(), (int) n.getY(), 0, 0, 32, 32, 32, 32);
			}
		}
	}
	
	public void drawBorders() {
		this.mc.getTextureManager().bindTexture(getBorder());
		this.drawModalRectWithCustomSizedTexture((width/2)-150, (height/2)-100, 0, 0, 300, 200, 300, 200);
	}
	
	public ResourceLocation getBackground() {
		return this.background;
	}
	
	public ResourceLocation getBorder() {
		return this.border;
	}
	
	public ArrayList<ResearchNode> getNodes(){
		return nodes;
	}
	
	public int getMapX() {
		return mapx;
	}
	
	public int getMapY() {
		return mapy;
	}
	
	/** CLICK EVENTS **/
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		
		if(this.releaseX==0)
			this.releaseX=this.x;
		
		if(this.releaseY==0)
			this.releaseY=this.y;
	
		this.xold=mouseX+releaseX;
		this.yold=mouseY+releaseY;
		if(mouseButton == 0) {
		for(ResearchNode n : getNodes()) {
			if(GuiEssentials.checkPoint(new Point(mouseX, mouseY), n)) {
				//Util.logger.info("RECANGLE: "+n.getBounds()+"| GUI: "+instance.get(n));
				this.mc.displayGuiScreen(instance.get(n));
			}else {
				//Util.logger.info("Missed: "+n.getBounds());
			}
		}
		}
	}
	
	@Override
	protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
		super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
		
		if(xold-mouseX >=0 && xold-mouseX <=(512+100))
			x=-(mouseX-xold);
		
		if(this.yold-mouseY >=0 && yold-mouseY <=(404))
			y=-(mouseY-yold);
	}
	
	@Override
	protected void mouseReleased(int mouseX, int mouseY, int state) {
		super.mouseReleased(mouseX, mouseY, state);
		releaseX=x;
		releaseY=y;
	}
	
}
