package com.GooberGunter.GrandSorcery.api.arcana;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import scala.sys.process.processInternal;

public class ProficiencyProvider implements ICapabilitySerializable<NBTBase>{
	
	@CapabilityInject(IArcanaProficiency.class)
	public static final Capability<IArcanaProficiency> PROFICIENCY_CAP = null;
	
	private IArcanaProficiency instance = PROFICIENCY_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == PROFICIENCY_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == PROFICIENCY_CAP ? PROFICIENCY_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return PROFICIENCY_CAP.getStorage().writeNBT(PROFICIENCY_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		PROFICIENCY_CAP.getStorage().readNBT(PROFICIENCY_CAP, this.instance, null, nbt);
	}


}
