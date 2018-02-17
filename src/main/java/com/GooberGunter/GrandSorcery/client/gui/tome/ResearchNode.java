package com.GooberGunter.GrandSorcery.client.gui.tome;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import com.GooberGunter.GrandSorcery.common.data.ResearchData;

import net.minecraft.util.ResourceLocation;

public class ResearchNode extends Rectangle{
	
	//TODO Map Rectangle Research Node to research
	public static Map<ResearchNode, GuiTomePage> instance = new HashMap<>();
	private GuiTomePage page;
	private ResourceLocation icon;
	
	/**Declares a new research node
	 * 
	 * @param x: x location
	 * @param y: y location
	 * @param type: page type
	 */
	public ResearchNode(int x, int y, GuiTomePage page, ResearchData data, ResourceLocation icon) {
		this.width=32;
		this.height=32;
		this.x=x;
		this.y=y;
		this.icon=icon;
		//Util.logger.info("map: "+page);
		this.page=page;
	}
	
	public GuiTomePage getPage() {
		return this.page;
	}
	
	public ResourceLocation getIcon() {
		return this.icon;
	}
	
	public void setXY(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
