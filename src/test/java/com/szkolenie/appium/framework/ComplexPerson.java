package com.szkolenie.appium.framework;

public final class ComplexPerson {
	private String name;
	private String language;
	private String location;
	private Personal personal;
	
	public ComplexPerson() {
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public String getLanguage() {
		return this.language;
	}
	
	public void setLanguage(final String language) {
		this.language = language;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(final String location) {
		this.location = location;
	}
	
	public Personal getPersonal() {
		return this.personal;
	}
	public final class Personal {
		
		private int age;
		private String hobby;
		
		public int getAge() {
			return this.age;
		}
		
		public String getHobby() {
			return this.hobby;
		}
	}
}
