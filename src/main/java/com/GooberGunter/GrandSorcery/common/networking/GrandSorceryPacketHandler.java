package com.GooberGunter.GrandSorcery.common.networking;

import com.GooberGunter.GrandSorcery.common.networking.packets.ElementMessage;
import com.GooberGunter.GrandSorcery.common.networking.packets.ExperimentMessage;
import com.GooberGunter.GrandSorcery.common.networking.packets.RequestMessage;
import com.GooberGunter.GrandSorcery.common.networking.packets.RequestPaperMessage;

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
		INSTANCE.registerMessage(ElementMessage.ElementMessageHandler.class, ElementMessage.class, nextID(), Side.CLIENT);
		INSTANCE.registerMessage(ExperimentMessage.ExperimentHandler.class, ExperimentMessage.class, nextID(), Side.CLIENT);
			
		//server packets
		INSTANCE.registerMessage(RequestMessage.RequestHandler.class, RequestMessage.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(RequestPaperMessage.RequestPaperHandler.class, RequestPaperMessage.class, nextID(), Side.SERVER);
		}
	
	public static int nextID() {
		return ++id;
	}
	
}
