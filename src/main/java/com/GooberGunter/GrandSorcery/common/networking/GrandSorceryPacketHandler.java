package com.GooberGunter.GrandSorcery.common.networking;

import com.GooberGunter.GrandSorcery.common.networking.handlers.ElementMessageHandler;
import com.GooberGunter.GrandSorcery.common.networking.handlers.RequestHandler;
import com.GooberGunter.GrandSorcery.common.networking.packets.ElementMessage;
import com.GooberGunter.GrandSorcery.common.networking.packets.RequestMessage;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class GrandSorceryPacketHandler {
	
	private static int id=0;
	
	public static SimpleNetworkWrapper INSTANCE;
	
	public GrandSorceryPacketHandler() {
	}
	
	public static void registerMessage(String channelName) {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
		//client packets
		INSTANCE.registerMessage(ElementMessageHandler.class, ElementMessage.class, nextID(), Side.CLIENT);
			
		//server packets
		INSTANCE.registerMessage(RequestHandler.class, RequestMessage.class, nextID(), Side.SERVER);
		}
	
	public static int nextID() {
		return ++id;
	}
	
}
