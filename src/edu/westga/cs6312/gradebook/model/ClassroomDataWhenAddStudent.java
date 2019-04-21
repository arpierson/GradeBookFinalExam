package edu.westga.cs6312.gradebook.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ClassroomDataWhenAddStudent {

	@Test
	void testWhenAdd1234AllenPierson() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(1234, "Allen", "Pierson");
		String result = theClassroom.getStudentList().get(0).toString();
		assertEquals("1234 Allen Pierson", result);
	}

	@Test
	void testWhenStudentis4321MauriceMoss() {
		ClassroomData theClassroom = new ClassroomData();
		theClassroom.addStudent(4321, "Maurice", "Moss");
		String result = theClassroom.getStudentList().get(0).toString();
		assertEquals("4321 Maurice Moss", result);
	}
}
