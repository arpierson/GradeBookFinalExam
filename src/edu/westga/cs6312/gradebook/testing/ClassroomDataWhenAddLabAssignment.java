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
class ClassroomDataWhenAddLabAssignment {

	@Test
	void testWhenAdding1LabGrade() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssingment(0, 10);
		double result = testClassroom.getLabAssignmentList().get(0);
		assertEquals(10, result);
	}

	@Test
	void testWhenAdding3LabGrades() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssingment(0, 10);
		testClassroom.addAssingment(0, 20);
		testClassroom.addAssingment(0, 30);
		double result = testClassroom.getLabAssignmentList().get(2);
		assertEquals(30, result);
	}
}
