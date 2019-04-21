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
class ClassroomDataWhenGetTotalLabPointsPossible {

	@Test
	void testWith3LabGrades() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		double result = testClassroom.getTotalLabPointsPossible();
		assertEquals(30, result);
	}

	@Test
	void testWith10LabGrades() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		testClassroom.addAssignment(0, 10);
		double result = testClassroom.getTotalLabPointsPossible();
		assertEquals(100, result);
	}
}
