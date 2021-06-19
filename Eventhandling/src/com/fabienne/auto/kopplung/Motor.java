package com.fabienne.auto.kopplung;

public class Motor {
	private static final int MAX_DREHZAHL = 5000;
	
	private int        drehzahl;
	private MotorState state;
	private Auto       auto;
	
	public Motor(Auto auto) {
		this.auto = auto;
	}
	
	void switchOn() {
		this.drehzahl = 1000;
		changeState(MotorState.ON);
	}
	
	void accelerate() {
		this.drehzahl += 1000;
		
		if (this.drehzahl >= MAX_DREHZAHL) {
			changeState(MotorState.DEFECT);
		}
	}
	
	void switchOff() {
		this.drehzahl = 0;
		
		if (!MotorState.DEFECT.equals(this.state)) {
			changeState(MotorState.OFF);
		}
	}
	
	private void changeState(MotorState state) {
		this.state = state;
		this.auto.notifyMotorStatus(state);
	}
	
	
	@Override
	public String toString() {
		return "Motor [drehzahl=" + drehzahl + ", state=" + state + "]";
	}


}
