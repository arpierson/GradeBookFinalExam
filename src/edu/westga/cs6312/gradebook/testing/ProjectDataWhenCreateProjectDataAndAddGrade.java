package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.StudentGradeBook;
import edu.westga.cs6312.gradebook.model.ProjectData;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class ProjectDataWhenCreateProjectDataAndAddGrade {

	@Test
	void testWhenCreateProjectDataAndAdd100Earned() {
		StudentGradeBook testProject = new ProjectData();
		testProject.addGrade(100);
		Double result = testProject.getPointsEarnedList().get(0);
		assertEquals(Double.valueOf(100), result);
	}

	@Test
	void testWhenAdding2147483647ToList() {
		StudentGradeBook testProject = new ProjectData();
		testProject.addGrade(2147483647);
		Double result = testProject.getPointsEarnedList().get(0);
		assertEquals(Double.valueOf(2147483647), result);
	}
	
	@Test
	void testWhenAdding0ToList() {
		StudentGradeBook testProject = new ProjectData();
		testProject.addGrade(0);
		Double result = testProject.getPointsEarnedList().get(0);
		assertEquals(Double.valueOf(0), result);
	}
}

