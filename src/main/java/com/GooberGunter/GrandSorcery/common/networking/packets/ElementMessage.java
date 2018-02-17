package com.GooberGunter.GrandSorcery.common.networking.packets;

import com.GooberGunter.GrandSorcery.api.arcana.MagickaProvider;
import com.GooberGunter.GrandSorcery.client.hud.GuiArcanometer;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ElementMessage implements IMessage{
	
	public ElementMessage() {}
	
	public int toSend;
	
	public ElementMessage(int w, double x, double z) {
		//TODO DO NOT USE MINECRAFT.GETMINECRAFT() THAT IS CLIENT SIDE
		this.toSend = DimensionManager.getWorld(w).getChunkFromBlockCoords(new BlockPos(x,0,z)).getCapability(MagickaProvider.MAG_CAP, null).getMagicka();
				//getChunkFromBlockCoords(new BlockPos(x, 0, z)).getCapability(ArcanaProvider.ARCANA_CAP, null).getArcana();
		//Util.logger.info("PACKET: "+toSend[0]+" "+toSend[1]+" "+toSend[2]+" "+toSend[3]+" "+toSend[4]);
		//Util.logger.info("PACKET: "+x+" "+z);
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		toSend = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(toSend);
	}

	public static class ElementMessageHandler implements IMessageHandler<ElementMessage, IMessage>{
			
		@Override
		public IMessage onMessage(ElementMessage message, MessageContext ctx) {
			//TODO check if this still works with multiple players
			GuiArcanometer.setStorage(message.toSend);
			
			return null;
		}

	}

}


