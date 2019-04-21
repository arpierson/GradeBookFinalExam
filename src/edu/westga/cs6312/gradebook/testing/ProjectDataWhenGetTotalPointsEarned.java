package edu.westga.cs6312.gradebook.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.gradebook.model.ProjectData;
import edu.westga.cs6312.gradebook.model.StudentGradeBook;

/**
 * 
 * @author Allen Pierson
 * @version 04212019
 *
 */
class ProjectDataWhenGetTotalPointsEarned {

	@Test
	void testProjectTotalWhenThereAre3Grades() {
		StudentGradeBook testProject = new ProjectData();
		testProject.addGrade(80);
		testProject.addGrade(18);
		testProject.addGrade(48);
		double result = testProject.getTotalPointsEarned();
		assertEquals(146.0, result);
	}

	@Test
	void testProjectTotalWhenThereAre5Grades() {
		StudentGradeBook testProject = new ProjectData();
		testProject.addGrade(100);
		testProject.addGrade(50);
		testProject.addGrade(50);
		testProject.addGrade(100);
		testProject.addGrade(20);
		double result = testProject.getTotalPointsEarned();
		assertEquals(320, result);
	}
	
	@Test
	void testProjectTotalWhenThereAre10Grades() {
		StudentGradeBook testProject = new ProjectData();
		testProject.addGrade(100);
		testProject.addGrade(50);
		testProject.addGrade(50);
		testProject.addGrade(100);
		testProject.addGrade(20);
		testProject.addGrade(100);
		testProject.addGrade(12);
		testProject.addGrade(100);
		testProject.addGrade(100);
		testProject.addGrade(20);
		double result = testProject.getTotalPointsEarned();
		assertEquals(652, result);
	}
}
