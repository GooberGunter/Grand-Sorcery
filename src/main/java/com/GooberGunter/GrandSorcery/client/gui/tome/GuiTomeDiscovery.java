package com.GooberGunter.GrandSorcery.client.gui.tome;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.GooberGunter.GrandSorcery.api.arcana.ArcanaType;
import com.GooberGunter.GrandSorcery.client.resources.GrandResource;
import com.GooberGunter.GrandSorcery.common.data.ResearchData;
import com.GooberGunter.GrandSorcery.common.data.ResearchData.ResearchTier;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import scala.Array;

public class GuiTomeDiscovery extends GuiTomeGeneral{
	
	public GuiTomeDiscovery() {
		super();
		DiscoveryTree.init(getMapX(), getMapY());
	}
	
	@Override
	public ArrayList<ResearchNode> getNodes() {
		//Util.logger.info("replaced");
		return DiscoveryTree.nodez;
	}
	
	@Override
	public void drawTree() {
		super.drawTree();
		
	}
	
	public void drawProgress() {
		for(int x=1; x<getNodes().size();x++) {
			ArrayList<Point> p = getLineCoords(getNodes().get(x-1), getNodes().get(x));
			Util.logger.info("Amount"+p.size());
			if(p.size()==2) {
				Point pf = p.get(1);
				Point pi = p.get(0);
				if(pf.getY()-pi.getY()==0) {
					this.drawHorizontalLine((int) pi.getX(), (int) pf.getX(),(int) pi.getY(), 0);
				}else {
					this.drawVerticalLine((int) pi.getX(), (int) pi.getY(), (int) pf.getY(), 0);
				}
			}
		}
	}
	
	public ArrayList<Point> getLineCoords(ResearchNode n1, ResearchNode n2) {
		int temp = getFacing(n1, n2);
		ArrayList<Point> tem2 = new ArrayList<>();

			switch(temp) {
			case 1://n1 is south of n2
				tem2.add(new Point((int) n1.getCenterX(),(int) n1.getY()));
				tem2.add(new Point((int) n2.getCenterX(), (int) n2.getMaxY()));
				break;
			case 2://line comes from the right of n1 (n1 is left of n2)
				tem2.add(new Point((int) n1.getMaxX(), (int) n1.getCenterY()));
				tem2.add(new Point((int) n2.getX(), (int) n2.getCenterY()));
				break;
			case 3://line comes from south of n1 (n1 is above n2)
				tem2.add(new Point((int) n1.getCenterX(), (int) n1.getMaxY()));
				tem2.add(new Point((int) n2.getCenterX(), (int) n2.getY()));
				break;
			case 4://line comes from left of n1 (n1 is right of n2)
				tem2.add(new Point((int) n1.getX(), (int) n1.getCenterY()));
				tem2.add(new Point((int) n2.getMaxX(), (int) n2.getCenterY()));
				break;
			}
		return tem2;
	}
	
	public int getFacing(Rectangle r1, Rectangle r2) {//1 North, 2 East, 3 South, 4 West
		if(r2.getX()-r1.getX()==0) {//vertical
			return r2.getY()-r1.getY()>0? 3 : 1;
		}
		if(r2.getY()-r1.getY()==0) {//horizontal
			return r2.getX()-r1.getX()>0? 2 : 4;
		}
		return 0;
	}
	
	
	@Override
	public void updateScreen() {
		super.updateScreen();
		//Util.logger.info("xy: "+getMapX()+" "+getMapY());
		DiscoveryTree.updateTree((width/2)+getMapX()-16, (height/2)+getMapY()-16);
	}
	
	public static class DiscoveryTree{
		public static  ResearchNode RsBook;
		public static  ResearchNode RsOres;
		public static  ResearchNode RsDungeons;
		public static  ResearchNode RsShrines;
		public static  ResearchNode RsElementals;
		public static  ArrayList<ResearchNode> nodez;
	
		public static void init(int x, int y) {
			RsBook = new ResearchNode(x,y, RsPages.bookPage, new ResearchData(ResearchTier.DISCOVERY, ArcanaType.ARCANA), GrandResource.BOOK_ICON);
			RsOres = new ResearchNode(x-32, y, RsPages.oresPage, new ResearchData(ResearchTier.DISCOVERY, ArcanaType.ARCANA), GrandResource.STAND_IN_ICON);
			RsDungeons = new ResearchNode(x-32, y-32, RsPages.dungeonPage, new ResearchData(ResearchTier.DISCOVERY, ArcanaType.ARCANA),GrandResource.STAND_IN_ICON);
			RsShrines = new ResearchNode(x-32, y-64, RsPages.shrinePage, new ResearchData(ResearchTier.DISCOVERY, ArcanaType.ARCANA), GrandResource.STAND_IN_ICON);
			RsElementals = new ResearchNode(x-64, y-32, RsPages.elementalPage, new ResearchData(ResearchTier.DISCOVERY, ArcanaType.ARCANA), GrandResource.STAND_IN_ICON);
			nodez = new ArrayList<>();
			for(ResearchNode n : new ResearchNode[] {RsBook, RsOres, RsDungeons, RsShrines, RsElementals}) {
				nodez.add(n);
			}

		}
		
		public static void updateTree(int x, int y) {
			RsBook.setXY(x, y);
			RsOres.setXY(x-64, y);
			RsDungeons.setXY(x-64, y-64);
			RsShrines.setXY(x-64, y-128);
			RsElementals.setXY(x-128, y-64);
		}
		
		
	}
}
