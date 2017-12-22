package com.GooberGunter.GrandSorcery.common.networking;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class ElementMessage implements IMessage{
	
	public ElementMessage() {}
	private int f;
	private int a;
	private int ea;
	private int w;
	private int ar;
	
	int[] toSend;
	public ElementMessage(int[] toSend) {
		this.toSend = toSend;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		f=buf.readInt();
		a=buf.readInt();
		ea=buf.readInt();
		w=buf.readInt();
		ar=buf.readInt();
		int[] tempboi = {f,a,ea,w,ar};
		toSend = tempboi;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		if(toSend.length==5) {
			f=toSend[0];
			a=toSend[1];
			ea=toSend[2];
			w=toSend[3];
			ar=toSend[4];
		}
		buf.writeInt(f);
		buf.writeInt(a);
		buf.writeInt(ea);
		buf.writeInt(w);
		buf.writeInt(ar);
	}

}
