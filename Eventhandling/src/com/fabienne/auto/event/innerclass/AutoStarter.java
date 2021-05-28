package com.fabienne.auto.event.innerclass;

public class AutoStarter {

	public static void main(String[] args) {
		Auto auto = new Auto();
		
		auto.switchOn();
		System.out.println(auto);

		auto.accelerate();
		auto.accelerate();
		auto.accelerate();
		auto.accelerate(); // Breaks the engine
		System.out.println(auto);
		
		auto.switchOff();
		System.out.println(auto);
	}
	
}
