package com.avalon.ymjhuahua.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * aop测试类
 *
 * @author huhao
 * @date 2018/07/11:46
 */
@Component
@Aspect
public class WebControllerAop {

    private final Log logger = LogFactory.getLog(WebControllerAop.class);

    @Pointcut(value = "execution(* com.avalon.ymjhuahua.controller..*.*(..)) && args(param)", argNames = "param")
    public void executeService(String param) {
    }

    @Before(value = "executeService(param)", argNames = "joinPoint, param")
    public void doBeforeAdvice(JoinPoint joinPoint, String param) {
        logger.info("doBefore 开始执行！" + param);
        Object[] objects = joinPoint.getArgs();
    }

    @AfterReturning(value = "executeService(param)", returning = "keys", argNames = "joinPoint, keys, param")
    public void doAfterReturningDemo1(JoinPoint joinPoint, String keys, String param) {
        logger.info("1keys: " + keys + " params: " + param);
    }

    @AfterReturning(value = "executeService(param)", returning = "keys", argNames = "joinPoint, keys, param")
    public void doAfterReturningDemo2(JoinPoint joinPoint, Object keys, String param) {
        logger.info("2keys: " + keys + " params: " + param);
    }

    @AfterReturning(value = "executeService(param)", returning = "keys", argNames = "joinPoint, keys, param")
    public void doAfterReturningDemo3(JoinPoint joinPoint, Integer keys, String param) {
        logger.info("3keys: " + keys);
    }

    @AfterThrowing(value = "executeService(params)", throwing = "exception", argNames = "joinPoint, exception, params")
    public void doAfterThrowingExcepion(JoinPoint joinPoint, Exception exception, String params) {
        logger.info(joinPoint.getTarget().getClass().getName(), exception);
    }

    @After(value = "executeService(param)", argNames = "joinPoint, param")
    public void doAfter(JoinPoint joinPoint, String param) {
        logger.info("doAfter: " + param);
    }

    @Around(value = "executeService(param)", argNames = "proceedingJoinPoint, param")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, String param) {
        Object result;
        try {
            logger.info("准备执行目标方法");
            result = proceedingJoinPoint.proceed();
            logger.info("结束执行目标方法");
            return result;
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage(), throwable);
            return null;
        }
    }
}
