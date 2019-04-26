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
class ClassroomDataWhenGetStudentLabAverage {

	@Test
	void testWithThreeLabGrades() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.setCurrentStudent(new Student(1234, "Allen", "Pierson"));
		Student theStudent = theClassroom.getCurrentStudent();
		theClassroom.addAssignment(0,  10);
		theClassroom.addAssignment(0,  10);
		theClassroom.addAssignment(0,  10);
		theStudent.addGrade(0, 9);
		theStudent.addGrade(0,  8.5);
		theStudent.addGrade(0,  7);
		double result = theClassroom.getStudentLabAverage(theStudent);
		assertEquals(81.7, result);
	}

	@Test
	void testWithFiveLabGrades() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.setCurrentStudent(new Student(1234, "Allen", "Pierson"));
		Student theStudent = theClassroom.getCurrentStudent();
		theClassroom.addAssignment(0,  10);
		theClassroom.addAssignment(0,  10);
		theClassroom.addAssignment(0,  10);
		theClassroom.addAssignment(0,  10);
		theClassroom.addAssignment(0,  10);
		theStudent.addGrade(0, 9);
		theStudent.addGrade(0,  8.5);
		theStudent.addGrade(0,  7);
		theStudent.addGrade(0,  10);
		theStudent.addGrade(0,  0);
		double result = theClassroom.getStudentLabAverage(theStudent);
		assertEquals(69.0, result);
	}
}
