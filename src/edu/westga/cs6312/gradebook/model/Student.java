package edu.westga.cs6312.gradebook.model;

import java.util.ArrayList;

/**
 * Class that creates a new student object
 * @author Allen Pierson
 * @version 04212019
 *
 */
public class Student {
	private LabData labGrades;
	private ProjectData projectGrades;
	private TestData testGrades;
	private int idNumber;
	private String firstName;
	private String lastName;
	
	/**
	 * 3-parameter constructor to instantiate the instance variables
	 * @param idNumber	the student's ID number
	 * @param firstName	the student's first name
	 * @param lastName	the student's last name
	 * 
	 * Preconditions:	idNumber !< 0
	 * 					firstName != null or empty string
	 * 					lastName != null or empty string
	 */
	public Student(int idNumber, String firstName, String lastName) {
		if (idNumber < 0) {
			throw new IllegalArgumentException("Student ID number cannot be less than 0");
		}
		if (firstName.equals(null) || firstName.equals("")) {
			throw new IllegalArgumentException("Student first name cannot be empty");
		}
		if (lastName.equals(null) || lastName.equals("")) {
			throw new IllegalArgumentException("Student last name cannot be empty");
		}
		this.labGrades = new LabData();
		this.projectGrades = new ProjectData();
		this.testGrades = new TestData();
		this.idNumber = idNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return this.idNumber + " " + this.firstName + " " + this.lastName;
	}
	
	/**
	 * Adds a new grade to a lab, project, or test based on gradeTypeChoice
	 * @param gradeTypeChoice	choice of which grade type (lab, project, or test)
	 * @param pointsEarned	points earned on the assignment
	 * 
	 * Precondition:	gradeTypeChoice must be 1, 2, or 3
	 */
	public void addGrade(int gradeTypeChoice, double pointsEarned) {
		switch (gradeTypeChoice) {
			case 1: this.labGrades.addGrade(pointsEarned);
					break;
			case 2: this.projectGrades.addGrade(pointsEarned);
					break;
			case 3: this.testGrades.addGrade(pointsEarned);
					break;
			default: throw new IllegalArgumentException("Grade type (lab, project, or test) not specified");
		}
	}
	
	/**
	 * Gets student's list of lab grades
	 * @return	ArrayList of lab grades
	 */
	public ArrayList<Double> getLabGradeList() {
		return this.labGrades.getPointsEarnedList();
	}
	
	/**
	 * Gets student's list of project grades
	 * @return	ArrayList of project grades
	 */
	public ArrayList<Double> getProjectGradeList() {
		return this.projectGrades.getPointsEarnedList();
	}
	
	/**
	 * Gets student's list of test grades
	 * @return	ArrayList of test grades
	 */
	public ArrayList<Double> getTestGradeList() {
		return this.testGrades.getPointsEarnedList();
	}
}
