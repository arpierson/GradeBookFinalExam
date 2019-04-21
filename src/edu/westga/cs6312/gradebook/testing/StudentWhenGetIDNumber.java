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
class StudentWhenGetIDNumber {

	@Test
	void testWhenIDIs1234() {
		Student testStudent = new Student(1234, "Allen", "Pierson");
		int result = testStudent.getIdNumber();
		assertEquals(1234, result);
	}

	@Test
	void testWhenIDIs123456789() {
		Student testStudent = new Student(123456789, "Allen", "Pierson");
		int result = testStudent.getIdNumber();
		assertEquals(123456789, result);
	}
}
