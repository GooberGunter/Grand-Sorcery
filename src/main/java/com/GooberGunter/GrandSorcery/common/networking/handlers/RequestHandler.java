package com.GooberGunter.GrandSorcery.common.networking.handlers;

import com.GooberGunter.GrandSorcery.common.networking.packets.ElementMessage;
import com.GooberGunter.GrandSorcery.common.networking.packets.RequestMessage;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class RequestHandler implements IMessageHandler<RequestMessage, ElementMessage>{

	@Override
	public ElementMessage onMessage(RequestMessage message, MessageContext ctx) {
		return new ElementMessage(message.x, message.z);
		
	}
}