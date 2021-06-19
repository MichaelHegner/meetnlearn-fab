package com.meetnlearn.fabien.schuladministration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Test;

public class AssessmentTest {

	@Test
	public void test() {
		assertThat(Assessment.A.getValue()).isEqualTo(6.0f);
		assertThat(Assessment.B.getValue()).isEqualTo(5.5f);
		assertThat(Assessment.C.getValue()).isEqualTo(5.0f);
		assertThat(Assessment.D.getValue()).isEqualTo(4.5f);
		assertThat(Assessment.E.getValue()).isEqualTo(4.0f);
		assertThat(Assessment.F.getValue()).isEqualTo(3.0f);
	}

}
