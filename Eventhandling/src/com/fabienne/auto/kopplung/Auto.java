package com.fabienne.auto.kopplung;

public class Auto {
	private boolean error;
	private Motor motor;
	
	public Auto() {
		this.motor = new Motor(this);
	}
	
	public void switchOn() {
		motor.switchOn();
	}
	
	public void accelerate() {
		motor.accelerate();
	}
	
	public void switchOff() {
		motor.switchOff();
		
	}
	
	public void notifyMotorStatus(MotorState state) {
		error = MotorState.DEFECT.equals(state);
	}

	@Override
	public String toString() {
		return "Auto [motor=" + motor + ", error=" + error + "]";
	}
	
}
