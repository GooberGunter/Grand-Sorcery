package com.GooberGunter.GrandSorcery.client.hud;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.GrandSorcery;
import com.GooberGunter.GrandSorcery.common.networking.GrandSorceryPacketHandler;
import com.GooberGunter.GrandSorcery.common.networking.packets.RequestMessage;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiArcanometer extends Gui{
	
	private static int storage;
	
	public static void render(Minecraft mc) {
		FontRenderer renderer = mc.fontRenderer;
		ScaledResolution scaledresolution = new ScaledResolution(mc);
		GrandSorceryPacketHandler hander = GrandSorcery.handler;
		
		mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":textures/gui/arcanometer.png"));
 		drawModalRectWithCustomSizedTexture(scaledresolution.getScaledWidth()-96, 0, 96, 48, 96, 48, 96, 48);
 		hander.INSTANCE.sendToServer(new RequestMessage(mc.player.dimension, mc.player.getPosition().getX(), mc.player.getPosition().getZ()));
 		//Util.logger.info("HANDLER: "+mc.player.getPosition().getX()+" "+mc.player.getPosition().getZ());
		
 		renderer.drawString(Integer.toString(storage), scaledresolution.getScaledWidth()-88.5f, 28.5f, 0x0000ee, false);
 		
 		
	}
	
	public static void setStorage(int io) {
		storage = io;
		//Util.logger.info("STORAGE: "+storage[0]+" "+storage[1]+" "+storage[2]+" "+storage[3]+" "+storage[4]);
	}
	
	public static int getStorage() {
		return storage;
	}
	
	
	
	
}
