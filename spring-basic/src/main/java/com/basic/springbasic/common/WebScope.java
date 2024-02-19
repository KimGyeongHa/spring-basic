package com.basic.springbasic.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(value = "request",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class WebScope  {

    private String url;
    private String uuid;

    @PostConstruct
    void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid  + "]" + "[" + url +  "]" + this);
    }

    @PreDestroy
    void close(){
        System.out.println("close : " + this);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUrl(){
        return url;
    }



}
