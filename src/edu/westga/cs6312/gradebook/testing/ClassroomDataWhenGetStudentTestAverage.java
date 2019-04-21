package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.ClassroomData;
import edu.westga.cs6312.gradebook.model.Student;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class ClassroomDataWhenGetStudentTestAverage {

	@Test
	void testWithThreeTestGrades() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(1234, "Allen", "Pierson");
		Student theStudent = theClassroom.getStudent(1234);
		theClassroom.addAssignment(2,  10);
		theClassroom.addAssignment(2,  10);
		theClassroom.addAssignment(2,  10);
		theStudent.addGrade(2, 9);
		theStudent.addGrade(2,  8.5);
		theStudent.addGrade(2,  7);
		double result = theClassroom.getStudentTestAverage(theStudent);
		assertEquals(81.7, result);
	}

	@Test
	void testWithFiveTestGrades() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(1234, "Allen", "Pierson");
		Student theStudent = theClassroom.getStudent(1234);
		theClassroom.addAssignment(2,  10);
		theClassroom.addAssignment(2,  10);
		theClassroom.addAssignment(2,  10);
		theClassroom.addAssignment(2,  10);
		theClassroom.addAssignment(2,  10);
		theStudent.addGrade(2, 9);
		theStudent.addGrade(2,  8.5);
		theStudent.addGrade(2,  7);
		theStudent.addGrade(2,  10);
		theStudent.addGrade(2,  0);
		double result = theClassroom.getStudentTestAverage(theStudent);
		assertEquals(69.0, result);
	}
}
