package com.springboot.sell.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 利用spring的AOP横向切面，完成拦截控制器（登录拦截等）
 *
 * @Pointcut(前面路径.控制类部分名称*或控制类全名 . 指定类下的方法/所有方法 . 方法下的参数{(..)为任意参数的同名方法、()为无数的同名方法、(指定方法的参数的类型{如Integer、String等})为同名方法下的方法}
 * 例如 @Pointcut("execution(public * com.springboot.sell.controller.Seller*.*(Integer,String,.....)
 * @Before用于被赋值@Pointcut()或者已含有@Pointcut的方法
 * @Author: jeff
 * @Date: 28/2/2022 上午 1:38
 * )")
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 不拦截卖家登录
     */
    @Pointcut("execution(public * com.springboot.sell.controller.Seller*.*(..))" +
            "&& !execution(public * com.springboot.sell.controller.SellerUserController.*(..))")
    public void verify() {
    }


//    @Before(value = "verify()")
//    public void doVerify() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        //查询cookie
//        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
//        if (cookie == null) {
//            log.warn("【登录校验】Cookie中查不多token");
//            throw new SellerAuthorizeException();
//        }
//
//        //去redis查询
//        String tokenValue = redisTemplate.opsForValue()
//                .get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
//
//        if (StringUtils.isEmpty(tokenValue)) {
//            log.warn("【登录校验】Redis中查不到token");
//            throw new SellerAuthorizeException();
//        }
//    }

}
