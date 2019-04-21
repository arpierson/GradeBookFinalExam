package edu.westga.cs6312.gradebook.model;

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
}
