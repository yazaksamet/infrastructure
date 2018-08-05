package ynwa.core.cache;

import java.util.List;

import ynwa.core.data.MLManager;
import ynwa.core.entity.MLString;

public class MLCache extends CacheBase<MLString, String, String> {

	@Override
	public List<MLString> GetAllRecords() {
		MLManager manager = new MLManager();
		return manager.SelectAll();
	}

	@Override
	public String GenerateKey(MLString entity) {
		return entity.getLanguage() + "@" +  entity.getKey();
	}

	@Override
	public String GenerateValue(MLString entity) {
		return entity.getValue();
	}

	@Override
	public String GetDefaultValue() {
		return "invalid ML";
	}
	
	public String GetValue(String key) {
		return null;
	}
	
	public String GetValue(String key, String language) {
		return this.Get(language + "@" +  key);
	}
	
}
