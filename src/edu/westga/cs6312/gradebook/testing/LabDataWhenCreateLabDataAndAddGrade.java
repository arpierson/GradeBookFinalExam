package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.StudentGradeBook;
import edu.westga.cs6312.gradebook.model.LabData;

/**
 * 
 * @author Allen Pierson
 * @version 04202019
 *
 */
class LabDataWhenCreateLabDataAndAddGrade {

	@Test
	void testWhenCreateLabDataAndAdd100Earned() {
		StudentGradeBook testLab = new LabData();
		testLab.addGrade(100);
		Double result = testLab.getPointsEarnedList().get(0);
		assertEquals(Double.valueOf(100), result);
	}

	@Test
	void testWhenAdding2147483647ToList() {
		StudentGradeBook testLab = new LabData();
		testLab.addGrade(2147483647);
		Double result = testLab.getPointsEarnedList().get(0);
		assertEquals(Double.valueOf(2147483647), result);
	}
	
	@Test
	void testWhenAdding0ToList() {
		StudentGradeBook testLab = new LabData();
		testLab.addGrade(0);
		Double result = testLab.getPointsEarnedList().get(0);
		assertEquals(Double.valueOf(0), result);
	}
}

