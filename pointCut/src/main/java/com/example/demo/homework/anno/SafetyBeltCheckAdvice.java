package com.example.demo.homework.anno;

import java.util.Random;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SafetyBeltCheckAdvice {

	// 목표1) 자동차에 start 메서드가 호출되면 안전벨트 착용 여부를 확인한다.
	// 목표2) 착용했을 경우 엔진을 기동시키고, 착용하지 않았을 경우 경고음을 들려준다.

	@Before("execution(* sta*()) && bean(luxuryCar)")
	public void myBefore(JoinPoint joinPoint) throws Throwable {	
		if(SafetyBeltCheckSensor.check() == true) {
			System.out.println("시스템 메세지 : 안전벨트 미착용. 운행 명령을 수행할 수 없습니다.\n시스템 메세지 : 안전벨트 착용 후 다시 시도 해주시기 바랍니다.");			
			System.out.println("=============== 고급차량 운행 결과 종료 ===============");			
			throw new Throwable("안전벨트 미착용으로 인한 운행 명령 거부");
		} else {
			System.out.println("시스템 메세지 : 운행 준비가 완료되었습니다.");	
		}
	}
}

class SafetyBeltCheckSensor{
	static Random rnd = new Random();
	
	public static boolean check() {
		// nextInt(2) ==> 0, 1 중 하나의 값을 임의로 리턴. 즉, check 메서드는 50% 확률로 true를 리턴
		if(rnd.nextInt(2) == 0) {
			return true;
		}
		return false;
	}
}
