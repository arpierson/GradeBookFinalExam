package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.ClassroomData;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class ClassroomDataWhenAddTestAssignment {

	@Test
	void testWhenAdding1TestGrade() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssignment(2, 10);
		double result = testClassroom.getTestAssignmentList().get(0);
		assertEquals(10, result);
	}

	@Test
	void testWhenAdding3TestGrades() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 20);
		testClassroom.addAssignment(2, 30);
		double result = testClassroom.getTestAssignmentList().get(2);
		assertEquals(30, result);
	}
}
