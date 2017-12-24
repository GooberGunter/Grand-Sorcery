package com.GooberGunter.GrandSorcery.common.networking.handlers;

import com.GooberGunter.GrandSorcery.client.hud.GuiArcanometer;
import com.GooberGunter.GrandSorcery.common.networking.packets.ElementMessage;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ElementMessageHandler implements IMessageHandler<ElementMessage, IMessage>{
	
	int[] elementReceived;
	
	@Override
	public IMessage onMessage(ElementMessage message, MessageContext ctx) {
		//TODO check if this still works with multiple players
		GuiArcanometer.setStorage(message.toSend);
		
		return null;
	}

}