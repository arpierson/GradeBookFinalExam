package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.TestData;
import edu.westga.cs6312.gradebook.model.StudentGradeBook;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class TestDataWhenGetTotalPointsEarned {

	@Test
	void testTestTotalWhenThereAre3Grades() {
		StudentGradeBook testTest = new TestData();
		testTest.addGrade(80);
		testTest.addGrade(18);
		testTest.addGrade(48);
		double result = testTest.getTotalPointsEarned();
		assertEquals(146.0, result);
	}

	@Test
	void testTestTotalWhenThereAre5Grades() {
		StudentGradeBook testTest = new TestData();
		testTest.addGrade(100);
		testTest.addGrade(50);
		testTest.addGrade(50);
		testTest.addGrade(100);
		testTest.addGrade(20);
		double result = testTest.getTotalPointsEarned();
		assertEquals(320, result);
	}
	
	@Test
	void testTestTotalWhenThereAre10Grades() {
		StudentGradeBook testTest = new TestData();
		testTest.addGrade(100);
		testTest.addGrade(50);
		testTest.addGrade(50);
		testTest.addGrade(100);
		testTest.addGrade(20);
		testTest.addGrade(100);
		testTest.addGrade(12);
		testTest.addGrade(100);
		testTest.addGrade(100);
		testTest.addGrade(20);
		double result = testTest.getTotalPointsEarned();
		assertEquals(652, result);
	}
}
