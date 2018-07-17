package com.avalon.testclient.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 定义切面类
 *
 * @author huhao
 * @date 2018/07/11:42
 */
@Component
@Aspect
public class WebConstrollerAop {

    @Pointcut("execution(* com.avalon.testclient..*.*(..))")
    public void executService() {

    }
}
