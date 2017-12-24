package com.GooberGunter.GrandSorcery.common.networking.packets;

import com.GooberGunter.GrandSorcery.api.arcana.ArcanaProvider;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ElementMessage implements IMessage{
	
	public ElementMessage() {}
	
	private int f;
	private int a;
	private int ea;
	private int w;
	private int ar;
	private int lf;
	private int dt;
	private int lg;
	private int sh;
	
	public int[] toSend;
	
	public ElementMessage(double x, double z) {
		//TODO DO NOT USE MINECRAFT.GETMINECRAFT() THAT IS CLIENT SIDE
		this.toSend = DimensionManager.getWorld(0).getChunkFromBlockCoords(new BlockPos(x,0,z)).getCapability(ArcanaProvider.ARCANA_CAP, null).getArcana();
				//getChunkFromBlockCoords(new BlockPos(x, 0, z)).getCapability(ArcanaProvider.ARCANA_CAP, null).getArcana();
		//Util.logger.info("PACKET: "+toSend[0]+" "+toSend[1]+" "+toSend[2]+" "+toSend[3]+" "+toSend[4]);
		//Util.logger.info("PACKET: "+x+" "+z);
		f=0;
		a=0;
		ea=0;
		w=0;
		ar=0;
		lf=0;
		dt=0;
		lg=0;
		sh=0;
		
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		f=buf.readInt();
		a=buf.readInt();
		ea=buf.readInt();
		w=buf.readInt();
		ar=buf.readInt();
		lf=buf.readInt();
		dt=buf.readInt();
		lg=buf.readInt();
		sh=buf.readInt();
		int[] tempboi = {f,a,ea,w,ar, lf, dt, lg, sh};
		toSend = tempboi;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		if(toSend == null) {
			return;
		}
		if(toSend.length==9) {
			f=toSend[0];
			a=toSend[1];
			ea=toSend[2];
			w=toSend[3];
			ar=toSend[4];
			lf=toSend[5];
			dt=toSend[6];
			lg=toSend[7];
			sh=toSend[8];
		}
		buf.writeInt(f);
		buf.writeInt(a);
		buf.writeInt(ea);
		buf.writeInt(w);
		buf.writeInt(ar);
		buf.writeInt(lf);
		buf.writeInt(dt);
		buf.writeInt(lg);
		buf.writeInt(sh);
	}

	

}


