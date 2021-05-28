package com.fabienne.auto.observer;

public class AutoStarter {

	public static void main(String[] args) {
		Auto auto = new Auto();
		
		auto.start();
		System.out.println(auto);

		
		auto.accelerate();
		auto.accelerate();
		auto.accelerate();
		auto.accelerate();
		auto.accelerate();
		
		
		auto.stop();
		System.out.println(auto);
	}
	
}
