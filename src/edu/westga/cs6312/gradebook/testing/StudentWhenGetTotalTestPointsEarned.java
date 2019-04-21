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
class StudentWhenGetTotalTestPointsEarned {

	@Test
	void testWith3TestGrades() {
		Student testClassroom = new Student(1234, "Allen", "Pierson");
		testClassroom.addGrade(2, 10);
		testClassroom.addGrade(2, 10);
		testClassroom.addGrade(2, 10);
		double result = testClassroom.getTotalTestPointsEarned();
		assertEquals(30, result);
	}

	@Test
	void testWith10TestGrades() {
		Student testClassroom = new Student(1234, "Allen", "Pierson");
		testClassroom.addGrade(2, 10);
		testClassroom.addGrade(2, 90);
		testClassroom.addGrade(2, 10);
		testClassroom.addGrade(2, 75);
		testClassroom.addGrade(2, 44);
		testClassroom.addGrade(2, 21);
		testClassroom.addGrade(2, 18);
		testClassroom.addGrade(2, 10);
		testClassroom.addGrade(2, 10);
		testClassroom.addGrade(2, 10);
		double result = testClassroom.getTotalTestPointsEarned();
		assertEquals(298, result);
	}

}
