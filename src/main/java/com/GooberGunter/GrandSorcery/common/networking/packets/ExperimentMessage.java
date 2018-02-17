package com.GooberGunter.GrandSorcery.common.networking.packets;

import com.GooberGunter.GrandSorcery.client.gui.ExperimentGui;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ExperimentMessage implements IMessage{
	private boolean toSend;
	
	public ExperimentMessage() {
		
	}
	
	public ExperimentMessage(boolean toSend) {
		this.toSend=toSend;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.toSend=buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(this.toSend);
	}
	

	public static class ExperimentHandler implements IMessageHandler<ExperimentMessage, IMessage>{

		public ExperimentHandler() {

		}
		
		@Override
		public IMessage onMessage(ExperimentMessage message, MessageContext ctx) {
			ExperimentGui.setPaper(message.toSend);
			return null;
		}
	}
}

