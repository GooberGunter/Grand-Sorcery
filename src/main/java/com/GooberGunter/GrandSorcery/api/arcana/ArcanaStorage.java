package com.GooberGunter.GrandSorcery.api.arcana;

import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ArcanaStorage implements IStorage<IArcana>{

	@Override
	public NBTBase writeNBT(Capability<IArcana> capability, IArcana instance, EnumFacing side) {
		//Util.logger.info("WRITING: "+instance.getArcana());
		return new NBTTagIntArray(instance.getArcana());
	}

	@Override
	public void readNBT(Capability<IArcana> capability, IArcana instance, EnumFacing side, NBTBase nbt) {
		instance.set(((NBTTagIntArray) nbt).getIntArray());
		int[] holder = ((NBTTagIntArray) nbt).getIntArray();
		/*int f=holder[0];
		int a=holder[1];
		int ea=holder[2];
		int w=holder[3];
		int ar=holder[4];
		//Util.logger.info("READING: "+f+", "+a+", "+ea+", "+w+", "+ar);*/
	}

}
