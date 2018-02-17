package com.GooberGunter.GrandSorcery.common.data;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.GooberGunter.GrandSorcery.api.arcana.ArcanaType;

/**
 * CLASS PURPOSE: assigns a tier and list of elements to different research
 * 
 * @author JEHan
 *
 */
public class ResearchData {
	//what data do we want
	private ResearchTier tier;
	private ArrayList<ArcanaType> types = new ArrayList<>();
	
	public ResearchData(ResearchTier tier, ArcanaType... type) {
		this.tier=tier;
		for(ArcanaType a : type) {
			types.add(a);
		}
	}
	
	public ArrayList<ArcanaType> getArcana() {
		return this.types;
	}
	
	
	public ResearchTier getType() {
		return this.tier;
	}
	
	/**
	 * DISCOVERER: Research done via research table; The player will match different runes to complete a thesis
	 * ALCHEMIST: Player will combine different alchemical properties to balance formulae (WIP)
	 * ARTIFACING: Player will use an architect's workbench to balance elements (SUPER ALPHA)
	 * Ritual: Same as Discoverer
	 * SPELL: Player will use an Arcane Speculum to create spells, different properties/spells can be learned from ruins or through research, by breaking down certain items in another page of the Speculum
	 * Ascension: player must travel to each dimension, defeat the 3 elemental bosses, collect all elemental gemstones, find the final stronghold, place all gemstones and take the heart from the final boss: ENDGAME TIER 
	 * @author JEHan
	 *
	 */
	public enum ResearchTier{
		DISCOVERY(1, GrandSorProgressionTier.DISCOVERER),
		SPELL(2, GrandSorProgressionTier.MAGUS),
		RITUAL(3, GrandSorProgressionTier.RITUALIST),
		ALCHEMY(4, GrandSorProgressionTier.ALCHEMIST),
		ASCENSION(5, GrandSorProgressionTier.KAMI),
		;
		
		private int id;
		private GrandSorProgressionTier tier;
		
		ResearchTier(int id, GrandSorProgressionTier tier){
			this.id=id;
			this.tier=tier;
		}
		
		public int getId() {
			return this.id;
		}
		
		public GrandSorProgressionTier getReq() {
			return this.tier;
		}
	}
}
