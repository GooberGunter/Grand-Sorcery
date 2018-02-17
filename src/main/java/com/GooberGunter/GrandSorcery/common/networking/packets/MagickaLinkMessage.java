package com.GooberGunter.GrandSorcery.common.networking.packets;

import java.util.UUID;

import com.GooberGunter.GrandSorcery.api.arcana.MagickaProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MagickaLinkMessage implements IMessage{
	public int w;
	public int magicka;
	public UUID id;
	
	public MagickaLinkMessage() {
	}
	
	public MagickaLinkMessage(UUID id, int w, int m){
		this.id=id;
		this.w=w;
		this.magicka=m;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		id = new UUID(buf.readLong(), buf.readLong());
		w = buf.readInt();
		magicka=buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(id.getMostSignificantBits());
		buf.writeLong(id.getLeastSignificantBits());
		buf.writeInt(w);
		buf.writeInt(magicka);
		
		
	}
	
	public static class LinkHandler implements IMessageHandler<MagickaLinkMessage, IMessage>{

		@Override
		public IMessage onMessage(MagickaLinkMessage message, MessageContext ctx) {
			DimensionManager.getWorld(message.w).getPlayerEntityByUUID(message.id).getCapability(MagickaProvider.MAG_CAP, null).set(message.magicka);
			return null;
		}
		
	}
	
}
