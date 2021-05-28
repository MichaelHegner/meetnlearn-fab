package com.fabienne.auto.observer;
import java.util.ArrayList;
import java.util.List;

public class Motor {
	private static final int MAX_DREHZAHL = 5000;
	
	private int drehzahl;
	private MotorState state;
	private List<MotorStatusListener> stateListeners = new ArrayList<>();
	
	void start() {
		this.drehzahl = 1000;
		changeState(MotorState.ON);
	}
	
	void accelerate() {
		this.drehzahl += 1000;
		
		if (this.drehzahl >= MAX_DREHZAHL) {
			changeState(MotorState.DEFECT);
		}
	}
	
	void stop() {
		this.drehzahl = 0;
		
		if (!MotorState.DEFECT.equals(this.state)) {
			changeState(MotorState.OFF);
		}
	}
	
	private void changeState(MotorState state) {
		this.state = state;
		stateListeners.forEach(l -> l.notifyMotorStatus(state));
	}
	
	
	public void addListener(MotorStatusListener listener) {
		this.stateListeners.add(listener);
	}

	@Override
	public String toString() {
		return "Motor [drehzahl=" + drehzahl + ", state=" + state + "]";
	}


}
