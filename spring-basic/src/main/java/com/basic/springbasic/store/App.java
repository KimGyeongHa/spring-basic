package com.basic.springbasic.store;

public class App {
    private Long AppId;
    private String appName;
    private int appPrice;

    public Long getAppId() {
        return AppId;
    }

    public void setAppId(Long appId) {
        AppId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppPrice() {
        return appPrice;
    }

    public void setAppPrice(int appPrice) {
        this.appPrice = appPrice;
    }
}
