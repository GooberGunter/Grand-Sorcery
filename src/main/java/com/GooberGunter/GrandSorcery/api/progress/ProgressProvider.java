package com.GooberGunter.GrandSorcery.api.progress;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import scala.tools.nsc.backend.icode.analysis.ProgramPoint;

public class ProgressProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject(IProgress.class)
	public static final Capability<IProgress> PROGRESS_CAP = null;
	
	private IProgress instance = PROGRESS_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PROGRESS_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == PROGRESS_CAP ? PROGRESS_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return PROGRESS_CAP.getStorage().writeNBT(PROGRESS_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PROGRESS_CAP.getStorage().readNBT(PROGRESS_CAP, this.instance, null, nbt);
	}

}
