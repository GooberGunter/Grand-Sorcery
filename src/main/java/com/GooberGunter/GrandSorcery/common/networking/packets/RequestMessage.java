package com.GooberGunter.GrandSorcery.common.networking.packets;

import com.GooberGunter.GrandSorcery.common.utils.Util;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class RequestMessage implements IMessage{
	
	public double x;
	public double z;
	
	public RequestMessage() {
		x=0;
		z=0;
	}
	
	public RequestMessage(double x, double z) {
		this.x=x;
		this.z=z;
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.x = buf.readDouble();
		this.z = buf.readDouble();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeDouble(x);
		buf.writeDouble(z);
		
	}
	
	
	
}
