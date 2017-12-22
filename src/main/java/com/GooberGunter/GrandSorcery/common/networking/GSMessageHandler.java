package com.GooberGunter.GrandSorcery.common.networking;

import com.GooberGunter.GrandSorcery.common.items.ItemArcanometer;
import com.GooberGunter.GrandSorcery.common.items.ModItems;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class GSMessageHandler implements IMessageHandler<ElementMessage, IMessage>{
	
	int[] elementReceived;
	
	@Override
	public IMessage onMessage(ElementMessage message, MessageContext ctx) {
		//TODO check if this still works with multiple players
		ItemArcanometer.setElement(message.toSend);
		
		return null;
	}

}
