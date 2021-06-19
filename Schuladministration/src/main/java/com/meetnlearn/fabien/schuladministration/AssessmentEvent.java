package com.meetnlearn.fabien.schuladministration;

import java.util.EventObject;

public class AssessmentEvent extends EventObject {
	private static final long serialVersionUID = 1L;
	
	private final String description;
	private final Assessment assessment;

	public AssessmentEvent(Object source, String description, Assessment assessment) {
		super(source);
		this.description = description;
		this.assessment = assessment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDescription() {
		return description;
	}

	public Assessment getAssessment() {
		return assessment;
	}
}
