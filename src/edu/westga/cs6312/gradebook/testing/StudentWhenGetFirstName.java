package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.Student;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class StudentWhenGetFirstName {

	@Test
	void testWhenIDIs1234() {
		Student testStudent = new Student(1234, "Allen", "Pierson");
		String result = testStudent.getFirstName();
		assertEquals("Allen", result);
	}

	@Test
	void testWhenIDIs123456789() {
		Student testStudent = new Student(123456789, "Doctor", "Who");
		String result = testStudent.getFirstName();
		assertEquals("Doctor", result);
	}
}
