package com.basic.springbasic.web.controller;

import com.basic.springbasic.common.WebScope;
import com.basic.springbasic.web.service.ScopeService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ScopeController {

    private final WebScope webScope;
    private final ScopeService scopeService;


    @RequestMapping("scope")
    @ResponseBody
    public String webScope(HttpServletRequest httpServletRequest){
        webScope.setUrl(httpServletRequest.getRequestURL().toString());
        System.out.println(scopeService.webScopeUrl());

        return "zzz";
    }

}
