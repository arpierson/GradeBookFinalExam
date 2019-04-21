package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.StudentGradeBook;
import edu.westga.cs6312.gradebook.model.TestData;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class TestDataWhenCreateTestDataAndAddGrade {

	@Test
	void testWhenCreateTestDataAndAdd100Earned() {
		StudentGradeBook testTest = new TestData();
		testTest.addGrade(100);
		Double result = testTest.getPointsEarnedList().get(0);
		assertEquals(Double.valueOf(100), result);
	}

	@Test
	void testWhenAdding2147483647ToList() {
		StudentGradeBook testTest = new TestData();
		testTest.addGrade(2147483647);
		Double result = testTest.getPointsEarnedList().get(0);
		assertEquals(Double.valueOf(2147483647), result);
	}
	
	@Test
	void testWhenAdding0ToList() {
		StudentGradeBook testTest = new TestData();
		testTest.addGrade(0);
		Double result = testTest.getPointsEarnedList().get(0);
		assertEquals(Double.valueOf(0), result);
	}
}

