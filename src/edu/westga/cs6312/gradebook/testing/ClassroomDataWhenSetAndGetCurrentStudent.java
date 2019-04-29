package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.ClassroomData;
import edu.westga.cs6312.gradebook.model.Student;

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
		assertEquals("Pierson, Allen 1234", result);
	}

	@Test
	void testWhenStudentIsRayCharles() {
		ClassroomData testClassroom = new ClassroomData();
		testClassroom.setCurrentStudent(new Student(2222, "Ray", "Charles"));
		String result = testClassroom.getCurrentStudent().toString();
		assertEquals("Charles, Ray 2222", result);
	}
}
