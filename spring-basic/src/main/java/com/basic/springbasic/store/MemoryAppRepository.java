package com.basic.springbasic.store;

import org.springframework.stereotype.Component;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryAppRepository implements AppRepository{
    Map<Long,String> store = new HashMap<>();

    @Override
    public void saveApp(App app) {
        store.put(app.getAppId(),app.getAppName());
    }

    @Override
    public String getAppName(Long AppId) {
        return store.get(AppId);
    }
}
