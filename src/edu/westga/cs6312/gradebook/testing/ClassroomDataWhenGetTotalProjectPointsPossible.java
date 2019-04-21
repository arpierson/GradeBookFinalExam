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
class ClassroomDataWhenGetTotalProjectPointsPossible {

	@Test
	void testWith3ProjectGrades() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		double result = testClassroom.getTotalProjectPointsPossible();
		assertEquals(30, result);
	}

	@Test
	void testWith10ProjectGrades() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		testClassroom.addAssignment(1, 10);
		double result = testClassroom.getTotalProjectPointsPossible();
		assertEquals(100, result);
	}
}
