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
class ClassroomDataWhenGetStudentOverallAverage {

	@Test
	void testWithThreeGradesOfEachType() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(1, 100);
		theClassroom.addAssignment(1, 100);
		theClassroom.addAssignment(1, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.addStudent(1234, "Allen", "Pierson");
		Student theStudent = theClassroom.getStudent(1234);
		theStudent.addGrade(0, 7);
		theStudent.addGrade(0, 10);
		theStudent.addGrade(0, 8);
		theStudent.addGrade(1, 90);
		theStudent.addGrade(1, 88.5);
		theStudent.addGrade(1, 72.75);
		theStudent.addGrade(2, 100);
		theStudent.addGrade(2, 0);
		theStudent.addGrade(2, 95);
		double result = theClassroom.getStudentOverallAverage(theStudent);
		assertEquals(74.8, result);
	}

	@Test
	void testWithFiveGradesOfEachType() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addAssignment(0, 5);
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(0, 20);
		theClassroom.addAssignment(1, 50);
		theClassroom.addAssignment(1, 50);
		theClassroom.addAssignment(1, 100);
		theClassroom.addAssignment(1, 100);
		theClassroom.addAssignment(1, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.addStudent(1234, "Allen", "Pierson");
		Student theStudent = theClassroom.getStudent(1234);
		theStudent.addGrade(0, 5);
		theStudent.addGrade(0, 10);
		theStudent.addGrade(0, 8);
		theStudent.addGrade(0, 8);
		theStudent.addGrade(0, 17.5);
		theStudent.addGrade(1, 45);
		theStudent.addGrade(1, 48.9);
		theStudent.addGrade(1, 90);
		theStudent.addGrade(1, 88.5);
		theStudent.addGrade(1, 72.75);
		theStudent.addGrade(2, 100);
		theStudent.addGrade(2, 0);
		theStudent.addGrade(2, 95);
		theStudent.addGrade(2, 100);
		theStudent.addGrade(2, 86.2);
		double result = theClassroom.getStudentOverallAverage(theStudent);
		assertEquals(81.1, result);
	}
}
