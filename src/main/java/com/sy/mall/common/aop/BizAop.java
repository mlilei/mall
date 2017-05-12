package com.sy.mall.common.aop;

import com.sy.mall.MallException;
import com.sy.mall.ResponseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by 李磊
 * on 2017/5/12.
 */
@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class BizAop {
    private static final Logger LOGGER = LoggerFactory.getLogger(BizAop.class);

    @Pointcut("execution(public * com.sy.mall.biz.*.*(..))")
    public void bizAll() {
    }

    @Around("bizAll()")
    public Object serviceAround(ProceedingJoinPoint jp) {
        String className = jp.getTarget().getClass().getName();
        ResponseResult result;
        try {
            result = (ResponseResult) jp.proceed();
        } catch (IllegalArgumentException e) {
            LOGGER.error(className + ",IllegalArgumentException:", e.getMessage());
            result = new ResponseResult(MallException.PARAMS_INVALID.getCode(), e.getMessage());
        } catch (MallException e) {
            LOGGER.error(className + ",error_MallException:", e);
            result = ResponseResult.createResult(e);
        } catch (Throwable e) {
            LOGGER.error(className + ",error_Throwable:", e);
            result = ResponseResult.createResult(MallException.ERROR);
        }
        return result;
    }
}
