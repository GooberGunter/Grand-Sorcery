package com.GooberGunter.GrandSorcery.common.networking.packets;

import com.GooberGunter.GrandSorcery.common.utils.Util;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class RequestMessage implements IMessage{
	
	public double x;
	public double z;
	public int w;
	
	public RequestMessage() {
		x=0;
		z=0;
		w=0;
	}
	
	public RequestMessage(int w, double x, double z) {
		this.w=w;
		this.x=x;
		this.z=z;
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.w = buf.readInt();
		this.x = buf.readDouble();
		this.z = buf.readDouble();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(w);
		buf.writeDouble(x);
		buf.writeDouble(z);
		
	}
	
	public static class RequestHandler implements IMessageHandler<RequestMessage, ElementMessage>{

		@Override
		public ElementMessage onMessage(RequestMessage message, MessageContext ctx) {
			return new ElementMessage(message.w, message.x, message.z);
			
		}
	}
	
}
