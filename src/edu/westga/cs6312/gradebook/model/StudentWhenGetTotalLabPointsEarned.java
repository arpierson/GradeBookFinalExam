package edu.westga.cs6312.gradebook.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class StudentWhenGetTotalLabPointsEarned {

	@Test
	void testWith3LabGrades() {
		Student testClassroom = new Student(1234, "Allen", "Pierson");
		testClassroom.addGrade(0, 10);
		testClassroom.addGrade(0, 10);
		testClassroom.addGrade(0, 10);
		double result = testClassroom.getTotalLabPointsEarned();
		assertEquals(30, result);
	}

	@Test
	void testWith10LabGrades() {
		Student testClassroom = new Student(1234, "Allen", "Pierson");
		testClassroom.addGrade(0, 10);
		testClassroom.addGrade(0, 90);
		testClassroom.addGrade(0, 10);
		testClassroom.addGrade(0, 75);
		testClassroom.addGrade(0, 44);
		testClassroom.addGrade(0, 21);
		testClassroom.addGrade(0, 18);
		testClassroom.addGrade(0, 10);
		testClassroom.addGrade(0, 10);
		testClassroom.addGrade(0, 10);
		double result = testClassroom.getTotalLabPointsEarned();
		assertEquals(298, result);
	}

}
