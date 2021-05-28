package com.fabienne.auto.event;

public class Auto implements PropertyChangedListener, Switchable {
	private boolean error;
	private Motor motor;
	private Light lightLeft;
	private Light lightRight;
	
	public Auto() {
		this.motor = new Motor();
		this.lightLeft = new Light();
		this.lightRight = new Light();
		
		this.motor.addPropertyStateChangedListener(this);
		this.lightLeft.addMotorStateChangedListener(this);
		this.lightRight.addMotorStateChangedListener(this);
	}
	
	public void switchOn() {
		motor.switchOn();
		lightLeft.switchOn();
		lightRight.switchOn();
	}
	
	public void switchOff() {
		motor.switchOff();
		lightLeft.switchOff();
		lightRight.switchOff();
	}

	@Override
	public boolean isSwitchedOn() {
		return motor.isSwitchedOn();
	}

	@Override
	public boolean isSwitchedOff() {
		return motor.isSwitchedOff();
	}
	
	public void accelerate() {
		motor.accelerate();
	}
	

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getSource() == motor) {
			System.out.println("Handle Motor Event");
			if(event.getNewValue().equals(MotorState.DEFECT)) {
				this.error = true;
				motor.switchOff();
			}
		}
		
		if(event.getSource() == lightLeft) {
			System.out.println("Handle Light Left Event");
		}

		if(event.getSource() == lightRight) {
			System.out.println("Handle Light Right Event");
		}
	}

	@Override
	public String toString() {
		return "Auto [defect=" + error + ", "
				+ "drehzahl=" + motor.getDrehzahl() + ", "
				+ "lightLeft=" + lightLeft.isSwitchedOn() + ", "
				+ "lightRight=" + lightRight.isSwitchedOn() + "]";
	}
	
	
}
