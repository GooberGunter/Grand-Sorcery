package com.GooberGunter.GrandSorcery.common.block.debugBlocks;

import com.GooberGunter.GrandSorcery.api.arcana.ArcanaProvider;
import com.GooberGunter.GrandSorcery.api.arcana.ArcanaType;
import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.DimensionManager;

public class ACTE extends TileEntity implements ITickable{
	
	private int[] arc;
	private long firstTick;
	
	public ACTE() {
		this.arc=new int[9];
		for(int i=0;i<9;i++) {
			this.arc[i]=0;
			
		}//sets local arc
		this.firstTick=DimensionManager.getWorld(0).getTotalWorldTime();
	}
	
	@Override
	public void update() {
		// If the modulo of the ticks since block placement of 20 is 0 i.e. if 1 second has passed, take arcana
		if((DimensionManager.getWorld(0).getTotalWorldTime()-firstTick)%40==0) {
			DimensionManager.getWorld(0).getChunkFromBlockCoords(Minecraft.getMinecraft().player.getPosition()).getCapability(ArcanaProvider.ARCANA_CAP, null).consume(ArcanaType.AIR, 1);
			DimensionManager.getWorld(0).getChunkFromBlockCoords(Minecraft.getMinecraft().player.getPosition()).getCapability(ArcanaProvider.ARCANA_CAP, null).logElements();
		}
		Util.logger.info("Date: "+(DimensionManager.getWorld(0).getTotalWorldTime()-firstTick)%40);
	}

}
