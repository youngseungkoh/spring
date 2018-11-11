package com.example.demo.aop.xml.step3;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

// Aspect란?
// 공통적인 부가로직(횡단관심사)을 어드바이스라고 하고,
// 새로운 애스팩트(클래스)를 열어서 다수의 Advice를 갖고있는 것을 애스팩트라고 한다.

@Component
public class MyAspect implements MethodInterceptor, MethodBeforeAdvice {
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("---------------- before advice ----------------");
	}
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		Object ret = invocation.proceed();
		System.out.println("=====Around After Advice======");
		
		return ret;
	}
	
}
