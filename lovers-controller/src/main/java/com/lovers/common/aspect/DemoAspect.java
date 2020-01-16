package com.lovers.common.aspect;

import com.lovers.common.annotation.DemoAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by wangzefeng on 2020/1/16 0016.
 */
@Slf4j
@Aspect
@Component
public class DemoAspect {
    @Pointcut("@annotation(com.lovers.common.annotation.DemoAnnotation)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        DemoAnnotation distributedLock = signature.getMethod().getAnnotation(DemoAnnotation.class);
        String value = distributedLock.value();
        return pjp.proceed();
    }
}
