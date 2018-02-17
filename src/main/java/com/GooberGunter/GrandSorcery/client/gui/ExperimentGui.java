package com.GooberGunter.GrandSorcery.client.gui;

import javax.annotation.Resource;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.GrandSorcery;
import com.GooberGunter.GrandSorcery.common.inventory.ContainerInscriberWorkbench;
import com.GooberGunter.GrandSorcery.common.networking.packets.RequestPaperMessage;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

public class ExperimentGui extends GuiContainer{
	
	int size;
	private static boolean hasPaper;
	ResourceLocation fire = new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/fire_bar.png");
	ResourceLocation water = new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/water_bar.png");
	ResourceLocation earth = new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/earth_bar.png");
	ResourceLocation air = new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/air_bar.png");
	ResourceLocation death = new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/death_bar.png");
	ResourceLocation life = new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/life_bar.png");
	ResourceLocation light = new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/light_bar.png");
	ResourceLocation dark = new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/darkness_bar.png");
	//from container/paper 
	
	public ExperimentGui(Container inventorySlotsIn) {
		super(inventorySlotsIn);
		this.xSize=304;
		this.ySize=249;
		this.size=this.height;
		this.hasPaper=false;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		this.drawInteractiveGui(partialTicks, mouseX, mouseY);
	}
	
	public static void setPaper(boolean paper) {
		hasPaper=paper;
	}
	
	protected void drawInteractiveGui(float partialTicks, int mouseX, int mouseY) {
		//TODO send message requesting paper
		GrandSorcery.handler.INSTANCE.sendToServer(new RequestPaperMessage(this.getTEPos()));
		
		this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/inscriber_workbench_empty.png"));
		this.drawModalRectWithCustomSizedTexture((this.width/2)-(this.xSize/2), (this.height/2)-(this.ySize/2), this.xSize, this.ySize, this.xSize, this.ySize, this.xSize, this.ySize);
		if(hasPaper==true) {
			this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/scroll.png"));
			this.drawModalRectWithCustomSizedTexture((this.width/2)-(245/2), (this.height/2)-(this.ySize/2)+(10), 245, 140, 245, 140, 245, 140);
			this.mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":"+"textures/gui/arcanist_equalizer/fire_bar.png"));
			this.drawModalRectWithCustomSizedTexture((this.width/2), (this.height/2)-70, 16, 64, 16, 64, 16, 64);
		}
	}
	
	public void drawResearchPuzzle(int n, ResourceLocation[] bars) {
		if(bars.length < n) {Util.logger.info("Bar resource is too small"); return;}
		
		switch(n) {
		case 1:
			this.mc.getTextureManager().bindTexture(bars[0]);
			this.drawModalRectWithCustomSizedTexture((this.width/2), (this.height/2)-70, 16, 64, 16, 64, 16, 64);
			break;
		case 2:
			this.mc.getTextureManager().bindTexture(bars[0]);
			this.drawModalRectWithCustomSizedTexture((this.width/2)-8, (this.height/2)-70, 16, 64, 16, 64, 16, 64);
			
			this.mc.getTextureManager().bindTexture(bars[1]);
			this.drawModalRectWithCustomSizedTexture((this.width/2)+8, (this.height/2)-70, 16, 64, 16, 64, 16, 64);
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		}
			
		
	}
	
	public BlockPos getTEPos() {
		ContainerInscriberWorkbench cont = (ContainerInscriberWorkbench) this.inventorySlots;
		return cont.te.getPos();
	}
	
	@Override
	protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
		super.mouseClickMove(mouseX, mouseY, clickedMouseButton, timeSinceLastClick);
		
	}

}
