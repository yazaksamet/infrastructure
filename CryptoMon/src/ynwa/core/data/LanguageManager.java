package ynwa.core.data;

import ynwa.core.entity.Language;

public class LanguageManager extends DbEntity<Language> {

	@Override
	public void ValidateSave(Language entity) {
		
	}

	@Override
	public String GetSelectAllQuery() {
		return "from Language";
	}

	@Override
	public String GetSelectSingleQuery() {
		return null;
	}

}
