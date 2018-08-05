package ynwa.core.data;

import ynwa.core.entity.MLString;

public class MLManager extends DbEntity<MLString> {

	@Override
	public void ValidateSave(MLString entity) {
		
	}

	@Override
	public String GetSelectAllQuery() {
		return "from MLString";
	}

	@Override
	public String GetSelectSingleQuery() {
		return null;
	}

}
