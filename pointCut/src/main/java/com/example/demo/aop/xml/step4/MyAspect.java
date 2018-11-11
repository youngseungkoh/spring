package com.example.demo.aop.xml.step4;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

// Aspect란?
// 공통적인 부가로직(횡단관심사)을 어드바이스라고 하고,
// 새로운 애스팩트(클래스)를 열어서 다수의 Advice를 갖고있는 것을 애스팩트라고 한다.

@Component
public class MyAspect
//implements MethodInterceptor, MethodBeforeAdvice
{
	
//	@Override
	public void before(
//			Method method, Object[] args, Object target
			JoinPoint joinPoint
			) throws Throwable {
		System.out.println("---------------- before advice ----------------");
	}
	
//	@Override
	public Object invoke(
//			MethodInvocation invocation
			ProceedingJoinPoint joinPoint
			) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		
		// 장점 1) 타겟 메서드에 전달되는 파라메터를 조작할 수 있다.
		Object[] args = joinPoint.getArgs();
		if(args != null && args.length > 0) {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			Arrays.asList(args).forEach(System.out::println);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		}
		
		// 장점 2) 타겟 메서드의 호출 여부를 결정할 수 있다.
//		Object ret = invocation.proceed();
		Object ret = joinPoint.proceed();
		System.out.println("=====Around After Advice======");
		
		// 장점 3) 타겟 메서드가 리턴한 결과를 조작할 수 있다.
		// ret의 자료형이 Object 이므로 아래처럼은 안됨
//		ret = ret + 1;
		// 그러니, 아래처럼 down casting 해서 쓰며 됨
		ret = (Integer)ret + 100;
		
		return ret;
	}
	
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.println("***********myAfterReturning**********");
	}

	public void myAfterThrowing(JoinPoint joinPoint) {
		System.out.println("***********myAfterThrowing**********");		
	}
	
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("***********myAfter**********");
	}
	
}
