package com.GooberGunter.GrandSorcery.common.networking;

import com.GooberGunter.GrandSorcery.GSReferences;
import com.google.common.graph.Network;

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
		
		//server packets
		
		//client packets
		INSTANCE.registerMessage(GSMessageHandler.class, ElementMessage.class, nextID(), Side.CLIENT);
	}
	
	public static int nextID() {
		return id++;
	}
	
}
