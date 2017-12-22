package com.GooberGunter.GrandSorcery.common.items;

import java.lang.ref.Reference;

import com.GooberGunter.GrandSorcery.GSReferences;

import it.unimi.dsi.fastutil.objects.ReferenceSet;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickItem;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemOldTome extends Item{
	
	public ItemOldTome(String registryName) {
		super();
		this.setUnlocalizedName(GSReferences.MODID + "."+registryName);
		this.setRegistryName(registryName);
		
	}
	
	
}
