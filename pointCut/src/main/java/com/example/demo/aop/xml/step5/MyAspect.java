package com.example.demo.aop.xml.step5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 아래의 설정을 Annotation 방식으로 표현하기!

@Component
@Aspect // 이 클래스가 AOP 설정정보를 갖고있다고 알려준다. 												(2)
public class MyAspect
{	
	@Pointcut("execution(int *(..))") // 													(1)
	public void pointcut() {}
	
//	<aop:config proxy-target-class="true">
//		<aop:pointcut expression="execution(int *(..))" id="pointcut"/> 					(1)
//		<aop:aspect ref="myAspect"> 														(2)
//			<aop:before method="myBefore" pointcut-ref="pointcut"/> 						(3)
//			<aop:around method="myAround" pointcut-ref="pointcut"/>							(4)
//			<aop:after-returning method="myAfterReturning" pointcut-ref="pointcut"/>		(5)
//			<aop:after-throwing method="myAfterThrowing" pointcut-ref="pointcut"/>			(6)
//			<aop:after method="myAfter" pointcut-ref="pointcut"/>							(7)
//		</aop:aspect>
//	</aop:config>
	
	@Before("pointcut()") //																(3)
	public void myBefore(JoinPoint joinPoint) throws Throwable {
		System.out.println("---------------- before advice ----------------");
	}
	
	@Around("pointcut()") //																(4)
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("-----Around Before Advice-----");
		Object ret = joinPoint.proceed();
		System.out.println("=====Around After Advice======");
		return ret;
	}
	
	// 괄호 안의 내용은 아래처럼 바꿀 수도 있다.
	// @AfterReturning("execution(int two())")
	
	@AfterReturning("pointcut()") //														(5)
	public void myAfterReturning(JoinPoint joinPoint) {
		System.out.println("***********myAfterReturning**********");
	}

	@AfterThrowing("pointcut()") //															(6)
	public void myAfterThrowing(JoinPoint joinPoint) {
		System.out.println("***********myAfterThrowing**********");		
	}
	
	@After("pointcut()") // 																(7)
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("***********myAfter**********");
	}
	
}
