package edu.westga.cs6312.gradebook.model;

import java.util.ArrayList;

/**
 * Creates a ClassroomData object to store students and calculate averages
 * @author Allen Pierson
 * @version 04212019
 *
 */
public class ClassroomData {
	private ArrayList<Student> studentList;
	private ArrayList<Double> labAssignmentList;
	private ArrayList<Double> projectAssignmentList;
	private ArrayList<Double> testAssignmentList;
	
	/**
	 * 0-parameter constructor to instantiate the instance variables
	 */
	public ClassroomData() {
		this.studentList = new ArrayList<Student>();
		this.labAssignmentList = new ArrayList<Double>();
		this.projectAssignmentList = new ArrayList<Double>();
		this.testAssignmentList = new ArrayList<Double>();
	}
	
	/**
	 * Adds a new assignment to the lab, project, or test list based on gradeTypeChoice
	 * @param gradeTypeChoice	choice of which grade type (lab, project, or test)
	 * @param pointsPossible	points possible on the assignment
	 * 
	 * Precondition:	gradeTypeChoice must be 1, 2, or 3
	 * 					pointsPossible !< 0
	 */
	public void addAssingment(int gradeTypeChoice, double pointsPossible) {
		if (pointsPossible <= -1) {
			throw new IllegalArgumentException("Assignment cannot be worth less than 0");
		}
		switch (gradeTypeChoice) {
			case 1: this.labAssignmentList.add(pointsPossible);
					break;
			case 2: this.projectAssignmentList.add(pointsPossible);
					break;
			case 3: this.testAssignmentList.add(pointsPossible);
					break;
			default: throw new IllegalArgumentException("Grade type (lab, project, or test) not specified");
		}
	}
}
