package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.ClassroomData;

/**
 * 
 * @author Allen Pierson
 * @version 04272019
 *
 */
class ClassroomDataWhenGetClassTestAverage {

	@Test
	void testWithTwoStudents() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(1234, "Allen", "Pierson");
		theClassroom.addStudent(4321, "Adrian", "Monk");
		theClassroom.addAssignment(2, 10);
		theClassroom.addAssignment(2, 10);
		theClassroom.addAssignment(2, 10);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(0));
		theClassroom.getCurrentStudent().addGrade(2, 7);
		theClassroom.getCurrentStudent().addGrade(2, 8);
		theClassroom.getCurrentStudent().addGrade(2, 9);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(1));
		theClassroom.getCurrentStudent().addGrade(2, 5);
		theClassroom.getCurrentStudent().addGrade(2, 9);
		theClassroom.getCurrentStudent().addGrade(2, 4);
		double result = theClassroom.getClassTestAverage();
		assertEquals(70.0, result);
	}

	@Test
	void testWithFourStudents() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(1234, "Allen", "Pierson");
		theClassroom.addStudent(4321, "Adrian", "Monk");
		theClassroom.addStudent(2222, "John", "Smith");
		theClassroom.addStudent(3333, "Luke", "Skywalker");
		theClassroom.addAssignment(2, 10);
		theClassroom.addAssignment(2, 10);
		theClassroom.addAssignment(2, 10);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(0));
		theClassroom.getCurrentStudent().addGrade(2, 7);
		theClassroom.getCurrentStudent().addGrade(2, 8);
		theClassroom.getCurrentStudent().addGrade(2, 9);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(1));
		theClassroom.getCurrentStudent().addGrade(2, 5);
		theClassroom.getCurrentStudent().addGrade(2, 9);
		theClassroom.getCurrentStudent().addGrade(2, 4);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(2));
		theClassroom.getCurrentStudent().addGrade(2, 10);
		theClassroom.getCurrentStudent().addGrade(2, 10);
		theClassroom.getCurrentStudent().addGrade(2, 10);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(3));
		theClassroom.getCurrentStudent().addGrade(2, 0);
		theClassroom.getCurrentStudent().addGrade(2, 9);
		theClassroom.getCurrentStudent().addGrade(2, 8);
		double result = theClassroom.getClassTestAverage();
		assertEquals(74.2, result);
	}
}
