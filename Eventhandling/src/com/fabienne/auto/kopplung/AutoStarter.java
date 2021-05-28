package com.fabienne.auto.kopplung;

public class AutoStarter {

	public static void main(String[] args) {
		Auto auto = new Auto();
		
		auto.start();
		System.out.println(auto);

		
		auto.accelerate();
		auto.accelerate();
		auto.accelerate();
		auto.accelerate(); // overheating engine
		
		
		auto.stop();
		System.out.println(auto);
	}
	
}
