package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.Student;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class StudentWhenGetTotalProjectPointsEarned {

	@Test
	void testWith3ProjectGrades() {
		Student testClassroom = new Student(1234, "Allen", "Pierson");
		testClassroom.addGrade(1, 10);
		testClassroom.addGrade(1, 10);
		testClassroom.addGrade(1, 10);
		double result = testClassroom.getTotalProjectPointsEarned();
		assertEquals(30, result);
	}

	@Test
	void testWith10ProjectGrades() {
		Student testClassroom = new Student(1234, "Allen", "Pierson");
		testClassroom.addGrade(1, 10);
		testClassroom.addGrade(1, 90);
		testClassroom.addGrade(1, 10);
		testClassroom.addGrade(1, 75);
		testClassroom.addGrade(1, 44);
		testClassroom.addGrade(1, 21);
		testClassroom.addGrade(1, 18);
		testClassroom.addGrade(1, 10);
		testClassroom.addGrade(1, 10);
		testClassroom.addGrade(1, 10);
		double result = testClassroom.getTotalProjectPointsEarned();
		assertEquals(298, result);
	}

}
