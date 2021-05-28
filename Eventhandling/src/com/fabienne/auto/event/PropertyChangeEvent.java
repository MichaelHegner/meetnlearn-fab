package com.fabienne.auto.event;

import java.util.EventObject;

public class PropertyChangeEvent extends EventObject {
	private static final long serialVersionUID = 1L;

	private final String propertyName;
	private final Object newValue;
	private final Object oldValue;
	
	/**
	 * Constructor.
	 * 
	 * @param source        die Quelle
	 * @param propertyName  der Eigentschaftsname  
	 * @param oldValue		der alte Wert
	 * @param newValue		der neue Wert
	 */
	public PropertyChangeEvent(Object source, String propertyName, Object oldValue, Object newValue) {
		super(source);
		this.propertyName = propertyName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}


	public String getPropertyName() {
		return propertyName;
	}

	public Object getNewValue() {
		return newValue;
	}

	public Object getOldValue() {
		return oldValue;
	}
	
}
