package edu.westga.cs6312.gradebook.model;

import java.util.ArrayList;

/**
 * Creates a ClassroomData object to store students and calculate averages
 * @author Allen Pierson
 * @version 04212019
 *
 */
public class ClassroomData {
	private ArrayList<Double> labAssignmentList;
	private ArrayList<Double> projectAssignmentList;
	private ArrayList<Double> testAssignmentList;
	
	/**
	 * 0-parameter constructor to instantiate the instance variables
	 */
	public ClassroomData() {
		this.labAssignmentList = new ArrayList<Double>();
		this.projectAssignmentList = new ArrayList<Double>();
		this.testAssignmentList = new ArrayList<Double>();
	}
	
	/**
	 * Adds a new assignment to the lab, project, or test list based on gradeTypeChoice
	 * @param gradeTypeChoice	choice of which grade type (lab, project, or test)
	 * @param pointsPossible	points possible on the assignment
	 * 
	 * Precondition:	gradeTypeChoice must be 0, 1, or 2
	 * 					pointsPossible !< 0
	 */
	public void addAssingment(int gradeTypeChoice, double pointsPossible) {
		if (pointsPossible <= -1) {
			throw new IllegalArgumentException("Assignment cannot be worth less than 0");
		}
		switch (gradeTypeChoice) {
			case 0: this.labAssignmentList.add(pointsPossible);
					break;
			case 1: this.projectAssignmentList.add(pointsPossible);
					break;
			case 2: this.testAssignmentList.add(pointsPossible);
					break;
			default: throw new IllegalArgumentException("Grade type (lab, project, or test) not specified");
		}
	}
	
	/**
	 * Returns lab assignment list
	 * @return	lab assignment list
	 */
	public ArrayList<Double> getLabAssignmentList() {
		return this.labAssignmentList;
	}
	
	/**
	 * Returns project assignment list
	 * @return	project assignment list
	 */
	public ArrayList<Double> getProjectAssignmentList() {
		return this.projectAssignmentList;
	}
	
	/**
	 * Returns test assignment list
	 * @return	test assignment list
	 */
	public ArrayList<Double> getTestAssignmentList() {
		return this.testAssignmentList;
	}
	
	/**
	 * Getter for total points possible for all lab assignments
	 * @return total points possible for all lab assignments
	 */
	public double getTotalLabPointsPossible() {
		double pointsPossible = 0;
		for (Double current : this.labAssignmentList) {
			pointsPossible += current;
		}
		return pointsPossible;
	}
}
