package com.GooberGunter.GrandSorcery.client.hud;

import com.GooberGunter.GrandSorcery.common.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber
public class GrandSorHudManager {
		
	public GrandSorHudManager() {
		
	}
	
	@SubscribeEvent
	public static void renderHud(RenderGameOverlayEvent.Post e) {
		
		if(FMLCommonHandler.instance().getEffectiveSide()==Side.CLIENT) {
			Minecraft mc = Minecraft.getMinecraft();
		
			if(ItemStack.areItemsEqual(mc.player.getHeldItem(EnumHand.OFF_HAND), ModItems.arcanometer.getDefaultInstance())) {
				if(e.getType() != ElementType.EXPERIENCE) {return;}
				GuiArcanometer.render(mc);
			
				//Util.logger.info("Width: "+mc.displayWidth+" Height: "+mc.displayHeight);
			}
		}
	}
}
