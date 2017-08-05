package com.veadan.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by Veadan on 2017/5/1.
 */

@Aspect
@Component
public class HttpAspect {

    private final static Logger LOGGER=LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut(value = "execution(public * com.veadan.recManage.controller.*.*.*(..))")
    public void log(){
    }


    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();

        LOGGER.info("url={}",request.getRequestURL());
        LOGGER.info("args={}",joinPoint.getArgs());
        LOGGER.info("method={}", request.getMethod());
        LOGGER.info("ip={}", request.getRemoteAddr());
        LOGGER.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }



    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object){

    }
}
