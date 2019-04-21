package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.LabData;
import edu.westga.cs6312.gradebook.model.StudentGradeBook;

/**
 * 
 * @author Allen Pierson
 * @version 04202019
 *
 */
class LabDataWhenGetTotalPointsEarned {

	@Test
	void testLabTotalWhenThereAre3Grades() {
		StudentGradeBook testLab = new LabData();
		testLab.addGrade(80);
		testLab.addGrade(18);
		testLab.addGrade(48);
		double result = testLab.getTotalPointsEarned();
		assertEquals(146.0, result);
	}

	@Test
	void testLabTotalWhenThereAre5Grades() {
		StudentGradeBook testLab = new LabData();
		testLab.addGrade(100);
		testLab.addGrade(50);
		testLab.addGrade(50);
		testLab.addGrade(100);
		testLab.addGrade(20);
		double result = testLab.getTotalPointsEarned();
		assertEquals(320, result);
	}
	
	@Test
	void testLabTotalWhenThereAre10Grades() {
		StudentGradeBook testLab = new LabData();
		testLab.addGrade(100);
		testLab.addGrade(50);
		testLab.addGrade(50);
		testLab.addGrade(100);
		testLab.addGrade(20);
		testLab.addGrade(100);
		testLab.addGrade(12);
		testLab.addGrade(100);
		testLab.addGrade(100);
		testLab.addGrade(20);
		double result = testLab.getTotalPointsEarned();
		assertEquals(652, result);
	}
}
