package com.GooberGunter.GrandSorcery.api.progress;

import com.GooberGunter.GrandSorcery.common.data.GrandSorProgressionTier;

public interface IProgress {
	public void setProgress(GrandSorProgressionTier tier);
	public GrandSorProgressionTier getProgress();
	
}
