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
class ClassroomDataWhenAddProjectAssignment {

	@Test
	void testWhenAdding1ProjectGrade() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssingment(1, 10);
		double result = testClassroom.getProjectAssignmentList().get(0);
		assertEquals(10, result);
	}

	@Test
	void testWhenAdding3ProjectGrades() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssingment(1, 10);
		testClassroom.addAssingment(1, 20);
		testClassroom.addAssingment(1, 30);
		double result = testClassroom.getProjectAssignmentList().get(2);
		assertEquals(30, result);
	}
}
