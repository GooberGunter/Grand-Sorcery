package com.GooberGunter.GrandSorcery.api.progress;

import com.GooberGunter.GrandSorcery.common.data.GrandSorProgressionTier;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ProgressStorage implements IStorage<IProgress>{

	@Override
	public NBTBase writeNBT(Capability<IProgress> capability, IProgress instance, EnumFacing side) {
		NBTTagCompound cmpd = new NBTTagCompound();
		if(instance.getProgress() != null)
		cmpd.setInteger("prog", instance.getProgress().getId());
		return cmpd;
	}

	@Override
	public void readNBT(Capability<IProgress> capability, IProgress instance, EnumFacing side, NBTBase nbt) {
		NBTTagCompound nbt1 = new NBTTagCompound();
		if(nbt1.getString("progress") != null)
		instance.setProgress(GrandSorProgressionTier.getTierById(nbt1.getInteger("prog")));
	}

}
