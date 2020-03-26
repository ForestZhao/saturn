package com.zjs.saturn.common.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            RequestWrapper requestWrapper = new RequestWrapper(request);
//            String body = requestWrapper.getBody();
//            String requestURI = request.getRequestURI();

            return true;
        } catch (Exception e){
            return false;
        }


    }








}
