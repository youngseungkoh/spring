package com.example.demo.homework.anno;

import org.springframework.stereotype.Component;

@Component
public class Engine {

	public void run() {
		System.out.println("시스템 메세지 : 운행을 시작합니다.\n시스템 메세지 : 운행중...");
	}

	public void stop() {
		System.out.println("시스템 메세지 : 운행을 종료합니다.");
	}

}
