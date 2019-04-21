package edu.westga.cs6312.gradebook.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class StudentWhenAddGrade {

	@Test
	void testWhenAddLabGrade() {
		Student testStudent = new Student(1234, "Doctor", "Who");
		testStudent.addGrade(1, 10);
		double result = testStudent.getLabGradeList().get(0);
		assertEquals(10, result);
	}

}
