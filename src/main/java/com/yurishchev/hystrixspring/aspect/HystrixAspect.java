package com.yurishchev.hystrixspring.aspect;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class HystrixAspect {

    @Around("@annotation(com.yurishchev.hystrixspring.FailFast)")
    public Object failFastAround(final ProceedingJoinPoint aJoinPoint) throws Throwable {
        String groupName = "HystrixAspect";
        String commandName = aJoinPoint.getSignature().getName();
        HystrixCommand.Setter theSetter =
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupName))
                        .andCommandKey(HystrixCommandKey.Factory.asKey(commandName));
        HystrixCommand theCommand = new HystrixCommand(theSetter) {
            @Override
            protected Object run() throws Exception {
                try {
                    return aJoinPoint.proceed();
                } catch (Exception e) {
                    throw e;
                } catch (Throwable e) {
                    throw new Exception(e);
                }
            }
        };
        return theCommand.execute();
    }

    @Around("@annotation(com.yurishchev.hystrixspring.FailSilent)")
    public Object failSilentAround(final ProceedingJoinPoint aJoinPoint) throws Throwable {
        String groupName = "HystrixAspect";
        String commandName = aJoinPoint.getSignature().getName();
        HystrixCommand.Setter theSetter =
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupName))
                        .andCommandKey(HystrixCommandKey.Factory.asKey(commandName));
        HystrixCommand theCommand = new HystrixCommand(theSetter) {
            @Override
            protected Object run() throws Exception {
                try {
                    return aJoinPoint.proceed();
                } catch (Exception e) {
                    throw e;
                } catch (Throwable e) {
                    throw new Exception(e);
                }
            }

            @Override
            protected Object getFallback() {
                return null;
            }
        };
        return theCommand.execute();
    }

    @Around("@annotation(com.yurishchev.hystrixspring.FailStatic)")
    public Object failStaticAround(final ProceedingJoinPoint aJoinPoint) throws Throwable {
        String groupName = "HystrixAspect";
        String commandName = aJoinPoint.getSignature().getName();
        HystrixCommand.Setter theSetter =
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupName))
                        .andCommandKey(HystrixCommandKey.Factory.asKey(commandName));
        HystrixCommand theCommand = new HystrixCommand(theSetter) {
            @Override
            protected Object run() throws Exception {
                try {
                    return aJoinPoint.proceed();
                } catch (Exception e) {
                    throw e;
                } catch (Throwable e) {
                    throw new Exception(e);
                }
            }

            @Override
            protected String getFallback() {
                return "This is a failure!";
            }
        };
        return theCommand.execute();
    }
}
