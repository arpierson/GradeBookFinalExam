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
class ClassroomDataWhenGetClassWeightedAverage {

	@Test
	void testWithTwoStudents() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(1234, "Allen", "Pierson");
		theClassroom.addStudent(4321, "Adrian", "Monk");
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(1, 50);
		theClassroom.addAssignment(1, 50);
		theClassroom.addAssignment(2, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(0));
		theClassroom.getCurrentStudent().addGrade(0, 7);
		theClassroom.getCurrentStudent().addGrade(0, 8);
		theClassroom.getCurrentStudent().addGrade(1, 40);
		theClassroom.getCurrentStudent().addGrade(1, 45);
		theClassroom.getCurrentStudent().addGrade(2, 82.5);
		theClassroom.getCurrentStudent().addGrade(2, 97.3);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(1));
		theClassroom.getCurrentStudent().addGrade(0, 5);
		theClassroom.getCurrentStudent().addGrade(0, 9);
		theClassroom.getCurrentStudent().addGrade(1, 50);
		theClassroom.getCurrentStudent().addGrade(1, 44);
		theClassroom.getCurrentStudent().addGrade(2, 72);
		theClassroom.getCurrentStudent().addGrade(2, 0);
		double result = theClassroom.getClassWeightedAverage();
		assertEquals(74.2, result);
	}

	@Test
	void testWithDecimalPoints() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(1234, "Allen", "Pierson");
		theClassroom.addStudent(4321, "Adrian", "Monk");
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(0, 10);
		theClassroom.addAssignment(1, 50);
		theClassroom.addAssignment(1, 50);
		theClassroom.addAssignment(2, 100);
		theClassroom.addAssignment(2, 100);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(0));
		theClassroom.getCurrentStudent().addGrade(0, 7.2);
		theClassroom.getCurrentStudent().addGrade(0, 8.8);
		theClassroom.getCurrentStudent().addGrade(1, 40.5);
		theClassroom.getCurrentStudent().addGrade(1, 45.1);
		theClassroom.getCurrentStudent().addGrade(2, 82.5);
		theClassroom.getCurrentStudent().addGrade(2, 97.3);
		theClassroom.setCurrentStudent(theClassroom.getStudentList().get(1));
		theClassroom.getCurrentStudent().addGrade(0, 5.1);
		theClassroom.getCurrentStudent().addGrade(0, 9.4);
		theClassroom.getCurrentStudent().addGrade(1, 50);
		theClassroom.getCurrentStudent().addGrade(1, 44.7);
		theClassroom.getCurrentStudent().addGrade(2, 72.9);
		theClassroom.getCurrentStudent().addGrade(2, 0);
		double result = theClassroom.getClassWeightedAverage();
		assertEquals(75.3, result);
	}
}
