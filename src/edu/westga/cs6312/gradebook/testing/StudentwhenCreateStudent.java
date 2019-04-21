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
class StudentwhenCreateStudent {

	@Test
	void testWhenStudentIs1234AllenPierson() {
		Student testStudent = new Student(1234, "Allen", "Pierson");
		String result = testStudent.toString();
		assertEquals("1234 Allen Pierson", result);
	}
	
	@Test
	void testWhenStudentis4321MauriceMoss() {
		Student testStudent = new Student(4321, "Maurice", "Moss");
		String result = testStudent.toString();
		assertEquals("4321 Maurice Moss", result);
	}

}
