package com.fabienne.auto.event.innerclass;

public class Auto implements Switchable {
	private boolean error;
	private Motor motor;
	private Light lightLeft;
	private Light lightRight;
	
	private class MotorStateChangeListener implements PropertyStateListener {

		@Override
		public void propertyChange(PropertyChangeEvent event) {
			System.out.println("Handle Motor Event");
			if(event.getNewValue().equals(MotorState.DEFECT)) {
				error = true;
				motor.switchOff();
			}
		}
		
	}
	
	private class LightStateChangeListener implements PropertyStateListener {
		
		@Override
		public void propertyChange(PropertyChangeEvent event) {
			System.out.println("Handle Light Event");
		}
		
	}
	
	
	public Auto() {
		this.motor = new Motor();
		this.lightLeft = new Light();
		this.lightRight = new Light();
		
		this.motor.addPropertyStateChangedListener(new Auto.MotorStateChangeListener());
		this.lightLeft.addPropertyStateChangedListener(new Auto.LightStateChangeListener());
		this.lightRight.addPropertyStateChangedListener(new Auto.LightStateChangeListener());
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
	public String toString() {
		return "Auto [defect=" + error + ", drehzahl=" + motor.getDrehzahl() + ", lightLeft=" + lightLeft.isSwitchedOn() + ", lightRight=" + lightRight.isSwitchedOn()
				+ "]";
	}
	
	
}
