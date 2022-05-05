package com.lhy.animalsystem.system.annotation.impl;

import com.alibaba.fastjson.JSON;
import com.lhy.animalsystem.system.annotation.MyLog;
import com.lhy.animalsystem.system.entity.SysLog;
import com.lhy.animalsystem.system.service.SysLogService;
import com.lhy.animalsystem.system.utils.HttpContextUtils;
import com.lhy.animalsystem.system.utils.IPUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.lang.reflect.Method;

/**
 * 系统日志：切面处理类
 */
@Aspect
@Component
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.lhy.animalsystem.system.annotation.MyLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //保存日志

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

        //获取操作
        MyLog myLog = method.getAnnotation(MyLog.class);
        String value = "";
        if (myLog != null) {
            //获取操作名称
           value = myLog.value();
        }
        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();

        //请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String params = JSON.toJSONString(args);

        //session获取用户名
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        String username = (String) request.getSession().getAttribute("loginUser");
        //获取ip地址
        String ipAddr = IPUtils.getIpAddr(request);

        //调用service保存SysLog实体类到数据库
        sysLogService.save(username,value,methodName,params,ipAddr);
    }

}
