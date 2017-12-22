package com.GooberGunter.GrandSorcery.client.hud;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.GooberGunter.GrandSorcery.common.items.ModItems;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class GuiArcanometer extends Gui{
	static int xSize;
	static int ySize;
	
	@SubscribeEvent
	public static void renderHud(RenderGameOverlayEvent.Post e) {
		Minecraft mc = Minecraft.getMinecraft();
		
		if(ItemStack.areItemsEqual(mc.player.getHeldItem(EnumHand.OFF_HAND), ModItems.arcanometer.getDefaultInstance())) {
			if(e.getType() != ElementType.EXPERIENCE) {
				//Util.logger.info("nope: "+e.getType());
				return;
			}
			Util.logger.info("test");
			mc.getTextureManager().bindTexture(new ResourceLocation(GSReferences.MODID+":textures/gui/arcanometer.png"));
			drawModalRectWithCustomSizedTexture(mc.displayWidth-64, 0, 64, 32, 64, 32, 64, 32);
		}
	}
	
	
}
