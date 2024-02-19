package com.basic.springbasic.store;

import java.lang.reflect.Member;
import java.util.List;

public interface AppRepository {
    void saveApp(App app);
    String getAppName(Long id);

}
