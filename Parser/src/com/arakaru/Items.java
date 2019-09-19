package com.arakaru;

public class Items {
	private String url;
	private String name;
	
	public Items(String url, String name) {
		
		this.url = url;
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return"Cсылка: "+url+" "+"Заголовок: "+name;
	}
}
