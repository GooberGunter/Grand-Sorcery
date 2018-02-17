package com.GooberGunter.GrandSorcery.client.gui.tome;

import java.awt.List;
import java.awt.Point;
import java.awt.Rectangle;

public class GuiEssentials {
	
	
	
	
	public static boolean checkPoint(Point point, Rectangle r) {
		//takes Point point and runs it through a list of rectangles located on the page
		if(r == null) {return false;}
		if(r.contains(point)) {
			return true;
		}
		return false;
	}
}
