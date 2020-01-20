package com.lovers.common.log;

import com.alibaba.dubbo.rpc.RpcContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by wangzefeng on 2020/1/16 0016.
 */
@Aspect
@Slf4j
@Component
public class RpcLogAspect {
    /**
     * 开始时间
     */
    private long startTime = 0L;
    /**
     * 结束时间
     */
    private long endTime = 0L;

    @Pointcut("execution(* *..service..*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void doBeforeInServiceLayer(JoinPoint joinPoint) {
        log.info("doBeforeInServiceLayer");
        startTime = System.currentTimeMillis();
    }

    @After("pointCut()")
    public void doAfterInServiceLayer(JoinPoint joinPoint) {
        log.info("doAfterInServiceLayer");
        endTime = System.currentTimeMillis();
        log.info("所用时间为：{}毫秒",(endTime-startTime));
    }

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint pjp) {
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            log.error("系统异常", throwable);
        }
        // 是否是消费端
        boolean consumerSide = RpcContext.getContext().isConsumerSide();
        // 获取最后一次提供方或调用方IP
        String ip = RpcContext.getContext().getRemoteHost();
        // 服务url
        String rpcUrl = RpcContext.getContext().getUrl().getParameter("application");
        log.info("consumerSide={}, ip={}, url={}", consumerSide, ip, rpcUrl);
        return result;
    }
}
