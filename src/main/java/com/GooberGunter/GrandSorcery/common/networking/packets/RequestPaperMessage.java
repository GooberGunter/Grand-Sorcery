package com.GooberGunter.GrandSorcery.common.networking.packets;

import com.GooberGunter.GrandSorcery.common.block.tileentities.ExperimentTableTE;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class RequestPaperMessage implements IMessage{
	public BlockPos p;
	
	public RequestPaperMessage() {
	
	}
	
	//this is used in the tile entity
	public RequestPaperMessage(BlockPos pos) {
		this.p=pos;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
			this.p= new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
			Util.logger.info("received p: "+this.p);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		if(this.p != null) {
			buf.writeInt(this.p.getX());
			buf.writeInt(this.p.getY());
			buf.writeInt(this.p.getZ());
		}
	}
	
	public static class RequestPaperHandler implements IMessageHandler<RequestPaperMessage, ExperimentMessage>{

		private boolean ppr;
		@Override
		public ExperimentMessage onMessage(RequestPaperMessage message, MessageContext ctx) {
			//TODO check world
			if(message.p != null) {
				ExperimentTableTE te = (ExperimentTableTE) DimensionManager.getWorld(0).getTileEntity(message.p);
			
			if(te != null && te instanceof ExperimentTableTE) {
				Util.logger.info("Te is good");
				ppr = te.getPpr();
				return new ExperimentMessage(ppr);
			}else {
				Util.logger.info("nope");
				return null;
			}
			}else {
				return null;
			}
		}

	}

}
