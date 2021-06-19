package com.meetnlearn.fabien.schuladministration;

import java.util.ArrayList;
import java.util.List;

public final class Student {
	private static final long LOWEST_ID = 20200400000L;
	
	private final long id;
	private final String firstName;
	private final String lastName;
	private final List<Modul> modules = new ArrayList<>();
	private List<AssessmentEventListener> stateListeners = new ArrayList<>();
	
	
	public Student(long id, String firstName, String lastName) {
		if (id < LOWEST_ID)                            throw new IllegalArgumentException("ID must be greater " + LOWEST_ID);
		if (lastName == null || lastName.length() < 3) throw new IllegalArgumentException("Name must be greater " + 3);
		
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + "; firstName=" + firstName + "; lastName=" + lastName + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void addAnlass(String description, Assessment assessment) {
		Modul modul = new Modul(description, assessment);
		this.modules.add(modul);
		
		if (Assessment.A.equals(assessment)) {
			for (AssessmentEventListener listener : stateListeners) {
				listener.propertyChange(new AssessmentEvent(modul, description, assessment));
			}
		}
	}
	
	public int getNumberOfAnlass() {
		return modules.size();
	}
	
	public float getAverageMarks() {
		float sum = 0.0f;
		
		for (Modul modul : modules) {
			sum += modul.getAssessment().getValue();
		}
		
		return sum / modules.size();
	}
	
	public void addListener(AssessmentEventListener listener) {
		this.stateListeners.add(listener);
	}
	
	public void removeListener(AssessmentEventListener listener) {
		this.stateListeners.remove(listener);
	}


	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
}
