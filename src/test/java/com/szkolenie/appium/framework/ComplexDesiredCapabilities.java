package com.szkolenie.appium.framework;

public class ComplexDesiredCapabilities {
	private String version;
	private String deviceName;
	private String udid;
	private String platformName;
	private String appPackage;
	private String appActivity;
	private boolean autoGrantPermissions;
	
	
	// Getter Methods
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getDeviceName() {
		return deviceName;
	}
	
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	public String getUdid() {
		return udid;
	}
	
	public void setUdid(String udid) {
		this.udid = udid;
	}
	
	public String getPlatformName() {
		return platformName;
	}
	
	// Setter Methods
	
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	
	public String getAppPackage() {
		return appPackage;
	}
	
	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}
	
	public String getAppActivity() {
		return appActivity;
	}
	
	public void setAppActivity(String appActivity) {
		this.appActivity = appActivity;
	}
	
	public boolean getAutoGrantPermissions() {
		return autoGrantPermissions;
	}
	
	public void setAutoGrantPermissions(boolean autoGrantPermissions) {
		this.autoGrantPermissions = autoGrantPermissions;
	}
}