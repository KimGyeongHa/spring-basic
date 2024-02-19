package com.basic.springbasic.store;

import com.basic.springbasic.annotation.MainDiscountPolicy;
import com.basic.springbasic.discount.DiscountPolicy;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
public class AppServiceImpl implements AppService{

    private final AppRepository appRepository;
    private final DiscountPolicy discountPolicy;
    public AppServiceImpl(AppRepository appRepository,@MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.appRepository = appRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public void saveApp(App app) {
        appRepository.saveApp(app);
    }

    @Override
    public String getAppName(Long AppId) {
        return appRepository.getAppName(AppId);
    }
}
