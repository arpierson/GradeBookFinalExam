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
class StudentWhenAddGrade {

	@Test
	void testWhenAddLabGrade() {
		Student testStudent = new Student(1234, "Doctor", "Who");
		testStudent.addGrade(1, 10);
		double result = testStudent.getLabGradeList().get(0);
		assertEquals(10, result);
	}

	@Test
	void testWhenAddProjectGrade() {
		Student testStudent = new Student(1234, "Doctor", "Who");
		testStudent.addGrade(1, 10);
		testStudent.addGrade(2, 50);
		double result = testStudent.getProjectGradeList().get(0);
		assertEquals(50, result);
	}
	
	@Test
	void testWhenAddTestGrade() {
		Student testStudent = new Student(1234, "Doctor", "Who");
		testStudent.addGrade(1, 10);
		testStudent.addGrade(2, 50);
		testStudent.addGrade(3, 100);
		double result = testStudent.getTestGradeList().get(0);
		assertEquals(100, result);
	}
}
