package com.meetnlearn.fabien.schuladministration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class StudentTest {

	@Test
	public void testConstructorWithValidID() {
		long   id        = Long.MAX_VALUE;
		String firstName = "TEST_FIRST_NAME";
		String lastName  = "TEST_LAST_NAME";
		
		Student studentToTest = new Student(id, firstName, lastName);
		
		assertThat(studentToTest.getId()).isEqualTo(id);
		assertThat(studentToTest.getFirstName()).isEqualTo(firstName);
		assertThat(studentToTest.getLastName()).isEqualTo(lastName);
	}
	
	@Test
	public void testConstructorWithInvalidID() {
		long   id        = 1;
		String firstName = "TEST_FIRST_NAME";
		String lastName  = "TEST_LAST_NAME";
		
		assertThrows(IllegalArgumentException.class, () -> new Student(id, firstName, lastName));
	}
	
	@Test
	public void testConstructorWithInvalidName() {
		long   id        = 1;
		String firstName = "TEST_FIRST_NAME";
		String lastName  = "ME";
		
		assertThrows(IllegalArgumentException.class, () -> new Student(id, firstName, lastName));
	}
	
	@Test
	public void testConstructorWithEmptyName() {
		long   id        = 1;
		String firstName = "TEST_FIRST_NAME";
		String lastName  = "";
		
		assertThrows(IllegalArgumentException.class, () -> new Student(id, firstName, lastName));
	}
	
	@Test
	public void testConstructorWithNameNull() {
		long   id        = 1;
		String firstName = "TEST_FIRST_NAME";
		String lastName  = null;
		
		assertThrows(IllegalArgumentException.class, () -> new Student(id, firstName, lastName));
	}
	
	@Test
	public void testToString() {
		long   id        = Long.MAX_VALUE;
		String firstName = "TEST_FIRST_NAME";
		String lastName  = "TEST_LAST_NAME";
		
		Student studentToTest = new Student(id, firstName, lastName);
		
		assertThat(studentToTest.toString())
			.contains("id=" + id)
			.contains("firstName=" + firstName)
			.contains("lastName=" + lastName);
	}
	
	@Test
	public void testEqualsAndHashcode() {
		EqualsVerifier.forClass(Student.class).withOnlyTheseFields("id").verify();
	}
	
	@Test
	public void testAssessmentAvgWithAAA() {
		Student student = new Student(Long.MAX_VALUE, "TEST_FIRST_NAME", "TEST_LAST_NAME");
		student.addAnlass("DESC_1", Assessment.A);
		student.addAnlass("DESC_2", Assessment.A);
		student.addAnlass("DESC_3", Assessment.A);
		
		assertThat(student.getAverageMarks()).isEqualTo(6.0f);
	}
	
	@Test
	public void testAssessmentAvgWithABC() {
		Student student = new Student(Long.MAX_VALUE, "TEST_FIRST_NAME", "TEST_LAST_NAME");
		student.addAnlass("DESC_1", Assessment.A);
		student.addAnlass("DESC_2", Assessment.B);
		student.addAnlass("DESC_3", Assessment.C);
		
		assertThat(student.getAverageMarks()).isEqualTo(5.5f);
	}
	

}
