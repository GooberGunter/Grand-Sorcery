package com.GooberGunter.GrandSorcery.common.data.player;

import java.util.ArrayList;
import java.util.List;

import com.GooberGunter.GrandSorcery.api.arcana.MagickaType;
import com.GooberGunter.GrandSorcery.common.magicka.spells.SpellBase;
import com.GooberGunter.GrandSorcery.common.magicka.spells.SpellFunction;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class PMDStorage implements IStorage<IPlayerMagickaData>{

	@Override
	public NBTBase writeNBT(Capability<IPlayerMagickaData> capability, IPlayerMagickaData instance, EnumFacing side) {
		NBTTagCompound c = new NBTTagCompound();
		c.setInteger("exp", instance.getXp());
		c.setInteger("level", instance.getLvl());
		if(!instance.getSpellList().isEmpty()) {
			NBTTagList list = new NBTTagList();
			
			for(SpellBase spell : instance.getSpellList()) {
				NBTTagCompound s = new NBTTagCompound();
				s.setString("name", spell.getName());
				s.setString("element", spell.getElement().name());
				s.setInteger("level", spell.getLevel());
				s.setString("function", spell.getFunction().name());
				list.appendTag(s);
			}
			if(list.tagCount()>0) {
				c.setTag("spells", list);
			}
		}
		return c;
	}

	@Override
	public void readNBT(Capability<IPlayerMagickaData> capability, IPlayerMagickaData instance, EnumFacing side,
			NBTBase nbt) {
		NBTTagCompound c = new NBTTagCompound();
		instance.setLvl(c.getInteger("level"));
		instance.setXp(c.getInteger("exp"));
		List<SpellBase> spells = new ArrayList<SpellBase>();
		NBTTagList list = (NBTTagList) c.getTag("spells");
		for(int i=0;i<list.tagCount();i++) {
			NBTTagCompound s = list.getCompoundTagAt(i);
			spells.add(new SpellBase(s.getString("name"), s.getInteger("level"), MagickaType.valueOf(s.getString("element")), SpellFunction.valueOf(s.getString("function"))));
		}
	}

}
