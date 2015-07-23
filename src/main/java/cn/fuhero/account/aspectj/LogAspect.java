package cn.fuhero.account.aspectj;

import cn.fuhero.account.model.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Created by Fu Zhong on 2015/7/4.
 *
 * AOP顺序：环绕通知(前)->前置通知->后置返回通知->后置异常通知->后置最终通知->环绕通知(后)
 * AOP名称: Around->Before->AfterReturning->AfterThrowing->After->Around
 */
@Aspect
@Component
public class LogAspect {

    // 本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Before(value = "execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //  请求的IP
        String ip = request.getRemoteAddr();
        // 方法名称
        JSONObject params = new JSONObject();
        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                params.put(joinPoint.getArgs()[i].getClass().getSimpleName(), joinPoint.getArgs()[i]);
            }
        }
        logger.debug("=====前置通知开始=====");
        logger.debug("请求方法:" + joinPoint.getTarget().getClass().getName());
        logger.debug("方法描述:" + joinPoint.getSignature().getName());
        logger.debug("请求参数:" + params);
        logger.debug("请求IP:" + ip);
        logger.debug("=====前置通知结束=====");
    }

    /**
     * 后置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @AfterReturning(value = "execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))", returning = "result")
    public void doAfterReturning (JoinPoint joinPoint, Object result) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //  请求的IP
        String ip = request.getRemoteAddr();
        // 方法名称
        JSONObject params = new JSONObject();
        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                params.put(joinPoint.getArgs()[i].getClass().getSimpleName(), joinPoint.getArgs()[i]);
            }
        }
        logger.debug("=====后置通知开始=====");
        logger.debug("请求方法:" + joinPoint.getTarget().getClass().getName());
        logger.debug("方法描述:" + joinPoint.getSignature().getName());
        logger.debug("请求参数:" + params.toString());
        logger.debug("请求IP:" + ip);
        logger.debug("返回参数:" + JSON.toJSONString(result));
        logger.debug("=====后置通知结束=====");
    }

    /**
     * 后置异常通知 用于拦截service层记录异常日志
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //获取请求ip
        String ip = request.getRemoteAddr();
        // 方法名称
        //获取用户请求方法的参数并序列化为JSON格式字符串
        JSONObject params = new JSONObject();
        if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {
            for ( int i = 0; i < joinPoint.getArgs().length; i++) {
                params.put(joinPoint.getArgs()[i].getClass().getSimpleName(), joinPoint.getArgs()[i]);
            }
        }
        logger.error("=====异常通知开始=====");
        logger.error("异常方法:" + joinPoint.getTarget().getClass().getName());
        logger.error("方法描述:" + joinPoint.getSignature().getName());
        logger.error("请求参数:" + params.toString());
        logger.error("请求IP:" + ip);
        logger.error("异常代码:" + e.getClass().getName());
        logger.error("异常信息:" + e.getMessage());
        logger.error("=====异常通知结束=====");
    }

    /**
     * 环绕通知
     *
     * @param joinPoint 切点
     */
    @Around(value = "execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))")
    public Result doAround (ProceedingJoinPoint joinPoint) {
        Result result = null;
        try {
            result = (Result) joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("异常代码:" + throwable.getClass().getName());
            logger.error("异常信息:" + throwable.getMessage());
            return Result.getErrorResult();
        }
        return result;
    }
}
