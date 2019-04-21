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
class ClassroomDataWhenGetTotalTestPointsPossible {

	@Test
	void testWith3TestGrades() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		double result = testClassroom.getTotalTestPointsPossible();
		assertEquals(30, result);
	}

	@Test
	void testWith10TestGrades() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		testClassroom.addAssignment(2, 10);
		double result = testClassroom.getTotalTestPointsPossible();
		assertEquals(100, result);
	}
}
