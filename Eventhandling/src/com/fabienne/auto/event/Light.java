package com.fabienne.auto.event;
import java.util.ArrayList;
import java.util.List;

public class Light implements Switchable {
	public static final String PROPERTY_NAME_STATE = "lightState";
	
	private boolean lightsOn;
	private List<PropertyChangedListener> stateListeners = new ArrayList<>();
	
	@Override
	public void switchOn() {
		if (isSwitchedOff()) {
			this.lightsOn = true;
			PropertyChangeEvent event = new PropertyChangeEvent(this, PROPERTY_NAME_STATE, false, true);
			firePropertyChangeEvent(event);
		}
	}
	
	@Override
	public void switchOff() {
		if (isSwitchedOn()) {
			this.lightsOn = false;
			PropertyChangeEvent event = new PropertyChangeEvent(this, PROPERTY_NAME_STATE, true, false);
			firePropertyChangeEvent(event);
		}
	}
	
	@Override
	public boolean isSwitchedOn() {
		return lightsOn;
	}

	@Override
	public boolean isSwitchedOff() {
		return !isSwitchedOn();
	}
	
	
	/**
	* Informiert alle PropertyStateChangedListener �ber PropertyStateChangeEvent.
	* @param event PropertyStateChangeEvent.
	*/
	private void firePropertyChangeEvent(PropertyChangeEvent event) {
		this.lightsOn = (boolean) event.getNewValue();
		stateListeners.forEach(l -> l.propertyChange(event));
	}
	
	/**
	 * Registriert einen PropertyStateChangedListener.
	 * 
	 * @param listener der PropertyStateChangedListener.
	 */
	public void addMotorStateChangedListener(PropertyChangedListener listener) {
		this.stateListeners.add(listener);
	}
	
	/**
	 * Deregistriert einen PropertyStateChangedListener.
	 * 
	 * @param listener der PropertyStateChangedListener.
	 */
	public void removeMotorStatusListener(PropertyChangedListener listener) {
		this.stateListeners.remove(listener);
	}

	@Override
	public String toString() {
		return "Light [lightsOn=" + lightsOn + "]";
	}
	
}
