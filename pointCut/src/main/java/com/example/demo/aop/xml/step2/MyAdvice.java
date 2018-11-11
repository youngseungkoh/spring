package com.example.demo.aop.xml.step2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

// MethodIntercepter 인터페이스를 구현한 Around Advice
// 타겟 메서드에 전달되는 파라메터를 조작하거나,
// 타겟 메서드가 리턴하는 값을 조작하고자 할 때 Around Advice를 주로 사용한다.
@Component
public class MyAdvice implements MethodInterceptor {
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("-----Around Before Advice-----");
		Object ret = invocation.proceed();
		System.out.println("=====Around After Advice======");
		
		return ret;
	}
	
}
