package com.GooberGunter.GrandSorcery.api.arcana;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class MagickaProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject(IMagicka.class)
	public static final Capability<IMagicka> MAG_CAP = null;
	
	private IMagicka instance = MAG_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == MAG_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == MAG_CAP ? MAG_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return MAG_CAP.getStorage().writeNBT(MAG_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		MAG_CAP.getStorage().readNBT(MAG_CAP, this.instance, null, nbt);
	}

}
