package com.fabienne.auto.observer;

public interface MotorStatusListener {
	void notifyMotorStatus(MotorState state);
}
