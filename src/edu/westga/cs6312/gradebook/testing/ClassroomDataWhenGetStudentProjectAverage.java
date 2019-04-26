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
class ClassroomDataWhenGetStudentProjectAverage {

	@Test
	void testWithThreeProjectGrades() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.setCurrentStudent(new Student(1234, "Allen", "Pierson"));
		Student theStudent = theClassroom.getCurrentStudent();
		theClassroom.addAssignment(1,  10);
		theClassroom.addAssignment(1,  10);
		theClassroom.addAssignment(1,  10);
		theStudent.addGrade(1, 9);
		theStudent.addGrade(1,  8.5);
		theStudent.addGrade(1,  7);
		double result = theClassroom.getStudentProjectAverage();
		assertEquals(81.7, result);
	}

	@Test
	void testWithFiveProjectGrades() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.setCurrentStudent(new Student(1234, "Allen", "Pierson"));
		Student theStudent = theClassroom.getCurrentStudent();
		theClassroom.addAssignment(1,  10);
		theClassroom.addAssignment(1,  10);
		theClassroom.addAssignment(1,  10);
		theClassroom.addAssignment(1,  10);
		theClassroom.addAssignment(1,  10);
		theStudent.addGrade(1, 9);
		theStudent.addGrade(1,  8.5);
		theStudent.addGrade(1,  7);
		theStudent.addGrade(1,  10);
		theStudent.addGrade(1,  0);
		double result = theClassroom.getStudentProjectAverage();
		assertEquals(69, result);
	}
}
