package com.GooberGunter.GrandSorcery.api.arcana;

import java.awt.Image;

import com.GooberGunter.GrandSorcery.common.utils.Util;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class MagickaStorage implements IStorage<IMagicka>{

	@Override
	public NBTBase writeNBT(Capability<IMagicka> capability, IMagicka instance, EnumFacing side) {
		//Util.logger.info("WRITING: "+instance.getArcana());
		return new NBTTagInt(instance.getMagicka());
	}

	@Override
	public void readNBT(Capability<IMagicka> capability, IMagicka instance, EnumFacing side, NBTBase nbt) {
		instance.set(((NBTTagInt) nbt).getInt());
	}

}
