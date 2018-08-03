package ynwa.currency.entity;

import java.util.Date;

public class Provider implements IGridEntity {
	private String id;
	private String name;
	private String url;
	private int reloadTime;
	private Date updateDate;
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getReloadTime() {
		return reloadTime;
	}
	public void setReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}
	@Override
	public String[] GetColumnNames() {
		return new String[]{"id", "name", "url", "reloadTime", "updateDate"};
	}
	
	public void Validate() {
		if (this.id == null || this.id.isEmpty()) {
			throw new IllegalArgumentException("Id cannot be empty");
		}
		
		if (this.name == null || this.name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		
		if (this.url == null || this.url.isEmpty()) {
			throw new IllegalArgumentException("Url cannot be empty");
		}
		
		if (this.reloadTime < 0) {
			throw new IllegalArgumentException("Reload time cannot be less than 0");
		}
	}
}
