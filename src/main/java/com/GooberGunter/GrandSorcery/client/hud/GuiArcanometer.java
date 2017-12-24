package com.GooberGunter.GrandSorcery.client.hud;

import org.lwjgl.opengl.GL11;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.GrandSorcery;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaProvider;
import com.GooberGunter.GrandSorcery.api.arcana.IArcana;
import com.GooberGunter.GrandSorcery.common.items.ModItems;
import com.GooberGunter.GrandSorcery.common.networking.GrandSorceryPacketHandler;
import com.GooberGunter.GrandSorcery.common.networking.packets.RequestMessage;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class GuiArcanometer extends Gui{
	
	private static int[] storage= {0,0,0,0,0,0,0,0,0};
	
	public static void render(Minecraft mc) {
		FontRenderer renderer = mc.fontRenderer;
		ScaledResolution scaledresolution = new ScaledResolution(mc);
		GrandSorceryPacketHandler hander = GrandSorcery.handler;
		
		mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":textures/gui/arcanometer.png"));
 		drawModalRectWithCustomSizedTexture(scaledresolution.getScaledWidth()-96, 0, 96, 48, 96, 48, 96, 48);
 		hander.INSTANCE.sendToServer(new RequestMessage(mc.player.getPosition().getX(), mc.player.getPosition().getZ()));
 		//Util.logger.info("HANDLER: "+mc.player.getPosition().getX()+" "+mc.player.getPosition().getZ());
 		
 		//water
 		if(storage[3]>9) {
 			renderer.drawString(Integer.toString(storage[3]), scaledresolution.getScaledWidth()-88.5f, 28.5f, 0x0000ee, false);
		}else { renderer.drawString(Integer.toString(storage[3]), scaledresolution.getScaledWidth()-85.5f, 28.5f, 0x0000ee, false);}
 		
 		//air
 		if(storage[1]>9) {
 			renderer.drawString(Integer.toString(storage[1]), scaledresolution.getScaledWidth()-74.5f, 23f, 0x00ffc5, false);
		}else { renderer.drawString(Integer.toString(storage[1]), scaledresolution.getScaledWidth()-71.5f, 23f, 0x00ffc5, false);}
 		
 		//arcana
 		if(storage[4]>9) {
 			renderer.drawString(Integer.toString(storage[4]), scaledresolution.getScaledWidth()-53.25f, 13f, 0x6A0090, false);
		}else { renderer.drawString(Integer.toString(storage[4]), scaledresolution.getScaledWidth()-50.25f, 13f, 0x6A0090, false);}
 		
 		//earth
 		if(storage[2]>9) {
 			renderer.drawString(Integer.toString(storage[2]), scaledresolution.getScaledWidth()-32.5f, 23f, 0x793810, false);
		}else { renderer.drawString(Integer.toString(storage[2]), scaledresolution.getScaledWidth()-29.5f, 23f, 0x793810, false);}
 		
 		//fire
 		if(storage[0]>9) {
 			renderer.drawString(Integer.toString(storage[0]), scaledresolution.getScaledWidth()-18.5f, 28.5f, 0xff0000, false);
		}else { renderer.drawString(Integer.toString(storage[0]), scaledresolution.getScaledWidth()-15.5f, 28.5f, 0xff0000, false);}
 		
 		
 		
	}
	
	public static void setStorage(int[] io) {
		storage = io;
		//Util.logger.info("STORAGE: "+storage[0]+" "+storage[1]+" "+storage[2]+" "+storage[3]+" "+storage[4]);
	}
	
	public static int[] getStorage() {
		if(storage != null) {
			return storage;
		}else {int[] x = {0,0,0,0,0}; return x;}
	}
	
	@SubscribeEvent
	public static void renderHud(RenderGameOverlayEvent.Post e) {
		Minecraft mc = Minecraft.getMinecraft();
		
		if(ItemStack.areItemsEqual(mc.player.getHeldItem(EnumHand.OFF_HAND), ModItems.arcanometer.getDefaultInstance())) {
			if(e.getType() != ElementType.EXPERIENCE) {return;}
			render(mc);
			
			//Util.logger.info("Width: "+mc.displayWidth+" Height: "+mc.displayHeight);
		}
	}
	
	
}
