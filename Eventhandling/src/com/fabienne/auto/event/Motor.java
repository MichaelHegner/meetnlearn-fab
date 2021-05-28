package com.fabienne.auto.event;
import java.util.ArrayList;
import java.util.List;

public class Motor implements Switchable {
	public static final String PROPERTY_NAME_STATE = "motorState";
	private static final int MAX_DREHZAHL = 5000;
	
	private int drehzahl     = 0;
	private MotorState state = MotorState.OFF;
	private List<PropertyChangedListener> stateListeners = new ArrayList<>();
	
	@Override
	public void switchOn() {
		if (MotorState.OFF.equals(state)) {
			this.drehzahl = 1000;
			PropertyChangeEvent event = new PropertyChangeEvent(this, PROPERTY_NAME_STATE, MotorState.OFF, MotorState.ON);
			firePropertyChangeEvent(event);
		}
	}
	
	@Override
	public void switchOff() {
		if (MotorState.ON.equals(state)) {
			this.drehzahl = 0;
			PropertyChangeEvent event = new PropertyChangeEvent(this, PROPERTY_NAME_STATE, MotorState.ON, MotorState.OFF);
			firePropertyChangeEvent(event);
		}
	}
	
	@Override
	public boolean isSwitchedOn() {
		return MotorState.ON.equals(state);
	}

	@Override
	public boolean isSwitchedOff() {
		return MotorState.OFF.equals(state);
	}
	
	public void accelerate() {
		if (MotorState.ON.equals(state)) {
			this.drehzahl += 1000;
			if (this.drehzahl >= MAX_DREHZAHL) {
				PropertyChangeEvent event = new PropertyChangeEvent(this, PROPERTY_NAME_STATE, MotorState.ON, MotorState.DEFECT);
				firePropertyChangeEvent(event);
			}
		}
	}
	
	/**
	* Informiert alle PropertyStateChangedListener über PropertyStateChangeEvent.
	* @param event PropertyStateChangeEvent.
	*/
	private void firePropertyChangeEvent(PropertyChangeEvent event) {
		this.state = (MotorState) event.getNewValue();
		stateListeners.forEach(l -> l.propertyChange(event));
	}
	
	/**
	 * Registriert einen PropertyStateChangedListener.
	 * 
	 * @param listener der PropertyStateChangedListener.
	 */
	public void addPropertyStateChangedListener(PropertyChangedListener listener) {
		this.stateListeners.add(listener);
	}
	
	/**
	 * Deregistriert einen PropertyStateChangedListener.
	 * 
	 * @param listener der PropertyStateChangedListener.
	 */
	public void removePropertyStateChangedListener(PropertyChangedListener listener) {
		this.stateListeners.remove(listener);
	}

	@Override
	public String toString() {
		return "Motor [drehzahl=" + drehzahl + ", state=" + state + "]";
	}

	public int getDrehzahl() {
		return drehzahl;
	}
	
	

}
