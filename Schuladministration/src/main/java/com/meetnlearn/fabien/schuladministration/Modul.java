package com.meetnlearn.fabien.schuladministration;

public class Modul {
	private final String description;
	private final Assessment assessment;
	
	public Modul(String description, Assessment assessment) {
		this.description = description;
		this.assessment = assessment;
	}

	@Override
	public String toString() {
		return "Modul [description=" + description + ", assessment=" + assessment + "]";
	}

	public String getDescription() {
		return description;
	}

	public Assessment getAssessment() {
		return assessment;
	}
}
