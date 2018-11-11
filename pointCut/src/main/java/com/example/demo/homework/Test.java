package com.example.demo.homework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("car-advice.xml");
		
		// 일반 차는 안전벨트 체크 기능이 없다. 즉, 어드바이스를 적용하지 않는다.
		Car car = context.getBean("car", Car.class);
		System.out.println("=============== 일반차량 운행 결과 시작 ===============");
		car.start();
		car.stop();
		System.out.println("=============== 일반차량 운행 결과 종료 ===============");
		
		
		System.out.println("");
		// 고급 차는 안전벨트 체크 기능이 있다. 즉, 어드바이스를 적용한다.
		Car luxuryCar = context.getBean("luxuryCar", Car.class);
		
		// 안전 벨트를 착용했으면 "운행을 시작합니다." 을 출력하고,
		// 안전 벨트를 착용하지 않았으면 "Fasten your seat belt, please."를 출력
		System.out.println("=============== 고급차량 운행 결과 시작 ===============");
		luxuryCar.start();
		luxuryCar.stop();
		System.out.println("=============== 고급차량 운행 결과 종료 ===============");
	}

}
