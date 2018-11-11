package com.example.demo.aop.xml.step5;

import org.springframework.stereotype.Component;

@Component
public class Second {
	public void one() {
		System.out.println("Second # one()");
	}
	public void one2() {
		System.out.println("Second # one2()");
	}
	public void two() {
		System.out.println("Second # two()");
		throw new RuntimeException("일부러 발생시키는 예외 발생!");
	}
	public double add(double a, double b) {
		System.out.println("Second # add(double a, double b)");
		return a + b;
	}
}
