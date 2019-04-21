package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.ClassroomData;

class ClassroomDataWhenAddStudent {

	@Test
	void testWhenAdd1234AllenPierson() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(1234, "Allen", "Pierson");
		theClassroom.addStudent(4321, "Maurice", "Moss");
		String result = theClassroom.getStudent(1234).toString();
		assertEquals("1234 Allen Pierson", result);
	}

	@Test
	void testWhenStudentis4321MauriceMoss() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(1234, "Allen", "Pierson");
		theClassroom.addStudent(4321, "Maurice", "Moss");
		String result = theClassroom.getStudent(4321).toString();
		assertEquals("4321 Maurice Moss", result);
	}
}
