package ynwa.core.cache;

import java.util.List;

import ynwa.core.data.LanguageManager;
import ynwa.core.entity.Language;

public class LangCache extends CacheBase<Language, String, Language> {

	@Override
	public List<Language> GetAllRecords() {
		LanguageManager manager = new LanguageManager();
		return manager.SelectAll();
	}

	@Override
	public String GenerateKey(Language entity) {
		return entity.getShortCode();
	}

	@Override
	public Language GenerateValue(Language entity) {
		return entity;
	}

	@Override
	public Language GetDefaultValue() {
		Language defaultLang = new Language();
		defaultLang.setName("Turkce");
		defaultLang.setShortCode("tr-TR");
		return defaultLang;
	}

}
