package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.Student;

/**
 * 
 * @author Allen Pierson
 * @version 04262019
 *
 */
class StudentWhenCompareToStudentB {

	@Test
	void testWhenComparePiersonToWho() {
		Student studentA = new Student(1234, "Allen", "Pierson");
		Student studentB = new Student(9999, "Doctor", "Who");
		int result = studentA.compareTo(studentB);
		assertEquals(-7, result);
	}

	@Test
	void testWhenCompareZigToWho() {
		Student studentA = new Student(1234, "Allen", "Zig");
		Student studentB = new Student(9999, "Doctor", "Who");
		int result = studentA.compareTo(studentB);
		assertEquals(3, result);
	}
	
	@Test
	void testWhenCompareWhatToWho() {
		Student studentA = new Student(1234, "Allen", "What");
		Student studentB = new Student(9999, "Doctor", "Who");
		int result = studentA.compareTo(studentB);
		assertEquals(-14, result);
	}
	
	@Test
	void testWhenComparePiersonToPierson() {
		Student studentA = new Student(1234, "Allen", "Pierson");
		Student studentB = new Student(9999, "Kayln", "Pierson");
		int result = studentA.compareTo(studentB);
		assertEquals(0, result);
	}
}
