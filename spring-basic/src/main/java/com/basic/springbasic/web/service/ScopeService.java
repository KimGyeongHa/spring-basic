package com.basic.springbasic.web.service;


import com.basic.springbasic.common.WebScope;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScopeService {

    private final WebScope webScope;

    public String webScopeUrl(){
        return webScope.getUrl();
    }


}
