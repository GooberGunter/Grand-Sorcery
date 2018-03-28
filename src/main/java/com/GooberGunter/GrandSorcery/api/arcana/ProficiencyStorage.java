package com.GooberGunter.GrandSorcery.api.arcana;

import net.minecraft.client.gui.IProgressMeter;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByteArray;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ProficiencyStorage implements IStorage<IArcanaProficiency>{

	@Override
	public NBTBase writeNBT(Capability<IArcanaProficiency> capability, IArcanaProficiency instance, EnumFacing side) {
		NBTTagCompound nbt = new NBTTagCompound();
		NBTTagList list = new NBTTagList();
		NBTTagCompound nbt1 = new NBTTagCompound();
		if(instance.getProficiency()[0] != null) {
			nbt1.setInteger("prim", instance.getProficiency()[0].getId());
			nbt1.setInteger("sec", instance.getProficiency()[1].getId());
		}
		
		return nbt1;
		
		/*
		 * 		NBTTagCompound nbt2 = new NBTTagCompound();
		 * nbt1.setString("prim", instance.getProficiency()[0].name());
		nbt2.setString("sec", instance.getProficiency()[1].name());
		list.appendTag(nbt1);
		list.appendTag(nbt2);
		nbt.setTag("profs", list);
		return nbt;*/
	}

	@Override
	public void readNBT(Capability<IArcanaProficiency> capability, IArcanaProficiency instance, EnumFacing side,
			NBTBase nbt) {
		/*NBTTagCompound comp = new NBTTagCompound();
		NBTTagList list = comp.getTagList("profs", 10);
		NBTTagCompound nbt1 = list.getCompoundTagAt(0);
		NBTTagCompound nbt2 = list.getCompoundTagAt(1);
		ArcanaType test = ArcanaType.valueOf(nbt1.getString("prim"));
		ArcanaType test2 = ArcanaType.valueOf(nbt2.getString("sec"));*/
		NBTTagCompound compound = new NBTTagCompound();
		if(instance.getProficiency()[0] != null) {
			MagickaType type1 = MagickaType.getTypebyId(compound.getInteger("prim:"));
			MagickaType type2 = MagickaType.getTypebyId(compound.getInteger("sec"));
			instance.setProficiency(type1, type2);
		}
		
	}
	
}
