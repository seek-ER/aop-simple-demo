package com.example.aopdemo.aspect;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(0)
public class PermissionSecondAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.example.aopdemo.annotation.PermissionAnnotation)")
    private void permissionCheck() {
    }

    @Around("permissionCheck()")
    public Object permissionCheckSecond(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("===================第二个切面===================：" + System.currentTimeMillis());

        //获取请求参数，详见接口类
        Object[] objects = joinPoint.getArgs();
        Long id = ((JSONObject) objects[0]).getLong("id");
        String name = ((JSONObject) objects[0]).getString("name");
        logger.info("id->>>>>>>>>>>>>>>>>>>>>>" + id);
        logger.info("name->>>>>>>>>>>>>>>>>>>>>>" + name);

        // name不是管理员则抛出异常
        if (!name.equals("admin")) {
            return JSON.parseObject("{\"message\":\"not admin\",\"code\":403}");
        }
        return joinPoint.proceed();
    }
}

