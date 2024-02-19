package com.basic.springbasic;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanLifeCycle{

    String url = "";

    public BeanLifeCycle() {
        System.out.println("생성자 호출 : "  + url);
        connect();
    }

    public String connect(){
        System.out.println("beanConnect : " + url);
        return url + "connet";
    }

    public String disConnect(){
        System.out.println("beanDisConnect : " + url);
        return url + "disconnect";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
