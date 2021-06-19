package com.meetnlearn.fabien.schuladministration;

public enum Assessment {
	A(6.0f), B(5.5f), C(5f), D(4.5f), E(4f), F(3.0f);
	
	private final float value;
	
	Assessment(float value) {
        this.value = value;
    }

	/**
	 * Die Zahl wird mit 100 multipliziert und gerundet, anschliessend wieder mit 100 dividiert.
	 * 
	 * @return the value
	 */
	public float getValue() {
		return (float) (Math.round(value * 100) / 100.0);
	}
	
}
