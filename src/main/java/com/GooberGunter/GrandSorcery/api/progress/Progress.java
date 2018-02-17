package com.GooberGunter.GrandSorcery.api.progress;

import com.GooberGunter.GrandSorcery.common.data.GrandSorProgressionTier;

public class Progress implements IProgress{

	private GrandSorProgressionTier tier;
	
	@Override
	public void setProgress(GrandSorProgressionTier tier) {
		this.tier=tier;
	}

	@Override
	public GrandSorProgressionTier getProgress() {
		return this.tier;
	}

}
