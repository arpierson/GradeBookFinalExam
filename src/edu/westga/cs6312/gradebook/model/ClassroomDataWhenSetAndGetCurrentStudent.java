package edu.westga.cs6312.gradebook.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author Allen Pierson
 * @version 04262019
 *
 */
class ClassroomDataWhenSetAndGetCurrentStudent {

	@Test
	void testWhenStudentIsAllenPierson() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.setCurrentStudent(new Student(1234, "Allen", "Pierson"));
		String result = testClassroom.getCurrentStudent().toString();
		assertEquals("1234 Allen Pierson", result);
	}

	@Test
	void testWhenStudentIsRayCharles() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.setCurrentStudent(new Student(2222, "Ray", "Charles"));
		String result = testClassroom.getCurrentStudent().toString();
		assertEquals("2222 Ray Charles", result);
	}
}
