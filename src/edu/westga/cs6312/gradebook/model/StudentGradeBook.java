package edu.westga.cs6312.gradebook.model;

import java.util.ArrayList;

/**
 * Abstract superclass for GradeBook type object
 * @author Allen Pierson
 * @version 041202019
 *
 */
public abstract class StudentGradeBook {
	private ArrayList<Double> pointsEarnedList;
	
	/**
	 * 0-parameter constructor to instantiate the instance variable
	 */
	public StudentGradeBook() {
		this.pointsEarnedList = new ArrayList<Double>();
	}
	
	/**
	 * Method to add a grade to the ArrayList
	 * @param pointsEarned	points earned on the assignment
	 * 
	 * Precondition:	pointsEarned !< 0
	 * 					pointsPossible !< 0
	 */
	public void addGrade(double pointsEarned) {
		if (pointsEarned <= -1) {
			throw new IllegalArgumentException("Points earned cannot be less than 0");
		}
		this.pointsEarnedList.add(pointsEarned);
	}
	
	/**
	 * Getter method for the student grade list
	 * @return the grade list
	 */
	public ArrayList<Double> getPointsEarnedList() {
		return this.pointsEarnedList;
	}
	
	/**
	 * Getter method that returns the sum total of all points earned for the assignments in the ArrayList
	 * @return	double	sum total of all points earned for the assignments in the ArrayList
	 */
	public double getTotalPointsEarned() {
		double totalPointsPossible = 0;
		for (Double current : this.pointsEarnedList) {
			totalPointsPossible += current;
		}
		return totalPointsPossible;
	}
}
