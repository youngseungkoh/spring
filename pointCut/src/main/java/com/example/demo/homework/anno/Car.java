package com.example.demo.homework.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	private Engine engine;
	
	public void start() {
		engine.run();
	}
	
	public void stop() {
		engine.stop();
	}
}
