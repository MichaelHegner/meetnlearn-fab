package com.meetnlearn.fabien.schuladministration;

public class Demo implements AssessmentEventListener {
	
	public static void main(String... args) {
		new Demo().execute();
	}

	private void execute() {
		Student student = new Student(20200400001L, "Fred", "Meier");
		student.addListener(this);
		student.addAnlass("OPA", Assessment.A);
		student.addAnlass("OPC", Assessment.B);
	}

	@Override
	public void propertyChange(AssessmentEvent event) {
		System.out.println("Congratulatoin to " + event.getDescription() + " : " + event.getAssessment());
	}

}
