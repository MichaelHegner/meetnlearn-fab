package com.fabienne.auto.kopplung;

public class Auto {
	private boolean error;
	private Motor motor;
	
	public Auto() {
		this.motor = new Motor(this);
	}
	
	public void start() {
		motor.start();
	}
	
	public void accelerate() {
		motor.accelerate();
	}
	
	public void stop() {
		motor.stop();
		
	}
	
	public void notifyMotorStatus(MotorState state) {
		error = MotorState.DEFECT.equals(state);
	}

	@Override
	public String toString() {
		return "Auto [motor=" + motor + ", error=" + error + "]";
	}
	
}
