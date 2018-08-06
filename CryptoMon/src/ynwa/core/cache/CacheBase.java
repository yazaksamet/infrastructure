package ynwa.core.cache;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public abstract class CacheBase<T, K, V> {
	private int reloadTime = 10000; // in miliseconds
	private HashMap<K, V> cacheMap = new HashMap<K, V>();
	
	public int getReloadTime() {
		return reloadTime;
	}
	public void setReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}
	
	public abstract List<T> GetAllRecords();
	public abstract K GenerateKey(T entity);
	public abstract V GenerateValue(T entity);
	public abstract V GetDefaultValue();
	
	public HashMap<K, V> GetCacheMap() {
		if (cacheMap == null || cacheMap.size() == 0) {
			LoadAll();
		}
		return cacheMap;
	}
	
	public void ClearCache() {
		this.cacheMap = null;
	}
	
	public void LoadAll() {
		if (cacheMap == null) {
			cacheMap = new HashMap<K, V>();
		}
		
		List<T> allRecords = this.GetAllRecords();
		
		for (T t : allRecords) {
			K key = GenerateKey(t);
			V value = GenerateValue(t);
			
			if (!cacheMap.containsKey(key)) {
				cacheMap.put(key, value);
			}
		} 
	}
	
	public  V Get(K key) {
		if (cacheMap == null || cacheMap.size() == 0) {
			LoadAll();
		}
		
		if (cacheMap.containsKey(key)) {
			return (V) cacheMap.get(key);
		}
		
		return this.GetDefaultValue();
	}
	
}
