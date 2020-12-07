package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void logAdvicePointcut(){}

    @Before("logAdvicePointcut()")
    public void logAdvice(){
        logger.info("get请求的advice被触发了");
    }
}
