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
	private ArrayList<Student> studentList;
	
	/**
	 * 0-parameter constructor to instantiate the instance variables
	 */
	public ClassroomData() {
		this.labAssignmentList = new ArrayList<Double>();
		this.projectAssignmentList = new ArrayList<Double>();
		this.testAssignmentList = new ArrayList<Double>();
		this.studentList = new ArrayList<Student>();
	}
	
	/**
	 * Adds a new assignment to the lab, project, or test list based on gradeTypeChoice
	 * @param gradeTypeChoice	choice of which grade type (lab, project, or test)
	 * @param pointsPossible	points possible on the assignment
	 * 
	 * Precondition:	gradeTypeChoice must be 0, 1, or 2
	 * 					pointsPossible !< 0
	 */
	public void addAssignment(int gradeTypeChoice, double pointsPossible) {
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
	
	/**
	 * Getter for total points possible for all project assignments
	 * @return total points possible for all project assignments
	 */
	public double getTotalProjectPointsPossible() {
		double pointsPossible = 0;
		for (Double current : this.projectAssignmentList) {
			pointsPossible += current;
		}
		return pointsPossible;
	}
	
	/**
	 * Getter for total points possible for all test assignments
	 * @return total points possible for all test assignments
	 */
	public double getTotalTestPointsPossible() {
		double pointsPossible = 0;
		for (Double current : this.testAssignmentList) {
			pointsPossible += current;
		}
		return pointsPossible;
	}
	
	/**
	 * Adds a new student to the class list
	 * @param idNumber	student's ID number
	 * @param firstName	student's first name
	 * @param lastName	student's last name
	 * 
	 * Preconditions:	idNumber !< 0
	 * 					firstName != null or empty string
	 * 					lastName != null or empty string
	 */
	public void addStudent(int idNumber, String firstName, String lastName) {
		if (idNumber < 0) {
			throw new IllegalArgumentException("Student ID number cannot be less than 0");
		}
		if (firstName.equals(null) || firstName.equals("")) {
			throw new IllegalArgumentException("Student first name cannot be empty");
		}
		if (lastName.equals(null) || lastName.equals("")) {
			throw new IllegalArgumentException("Student last name cannot be empty");
		}
		this.studentList.add(new Student(idNumber, firstName, lastName));
	}
	
	/**
	 * Returns the student roster list
	 * @return the student roster list
	 */
	public ArrayList<Student> getStudentList() {
		return this.studentList;
	}
	
	/**
	 * Returns a student from the student roster if there is a matching ID number
	 * @param studentID	the student's ID number that is being searched for
	 * @return	Student whose ID number == studentID param
	 */
	public Student getStudent(int studentID) {
		Student theStudent = null;
		for (Student current : this.studentList) {
			if (studentID == current.getIdNumber()) {
				theStudent = current;
			}
		}
		return theStudent;
	}
	
	/**
	 * Returns straight average of lab grades for a student
	 * @param theStudent	The student whose average is being calculated
	 * @return	straight average of lab grades for a student
	 * 
	 * Preconditions:	theStudent != null
	 * 					Student lab grade list size == Classroom lab assignment list
	 */
	public double getStudentLabAverage(Student theStudent) {
		if (theStudent == null) {
			throw new IllegalArgumentException("Student cannot be null");
		}
		if (theStudent.getLabGradeList().size() != this.labAssignmentList.size()) {
			throw new IllegalArgumentException("Student lab grade list contains incorrect amount of grades earned");
		}
		return this.roundAverage(theStudent.getTotalLabPointsEarned() / this.getTotalLabPointsPossible());
	}
	
	/**
	 * Returns straight average of project grades for a student
	 * @param theStudent	The student whose average is being calculated
	 * @return	straight average of project grades for a student
	 * 
	 * Preconditions:	theStudent != null
	 * 					Student project grade list size == Classroom project assignment list
	 */
	public double getStudentProjectAverage(Student theStudent) {
		if (theStudent == null) {
			throw new IllegalArgumentException("Student cannot be null");
		}
		if (theStudent.getProjectGradeList().size() != this.projectAssignmentList.size()) {
			throw new IllegalArgumentException("Student project grade list contains incorrect amount of grades earned");
		}
		return this.roundAverage(theStudent.getTotalProjectPointsEarned() / this.getTotalProjectPointsPossible());
	}
	
	/**
	 * Returns straight average of test grades for a student
	 * @param theStudent	The student whose average is being calculated
	 * @return	straight average of test grades for a student
	 * 
	 * Preconditions:	theStudent != null
	 * 					Student test grade list size == Classroom test assignment list
	 */
	public double getStudentTestAverage(Student theStudent) {
		if (theStudent == null) {
			throw new IllegalArgumentException("Student cannot be null");
		}
		if (theStudent.getTestGradeList().size() != this.testAssignmentList.size()) {
			throw new IllegalArgumentException("Student test grade list contains incorrect amount of grades earned");
		}
		return this.roundAverage(theStudent.getTotalTestPointsEarned() / this.getTotalTestPointsPossible());
	}
	
	/**
	 * Returns the straight average of all grades for a student
	 * @param theStudent	The student whose average is being calculated
	 * @return	the straight average of all grades for a student
	 * 
	 * Preconditions:	theStudent != null
	 * 					Student lab grade list size == Classroom lab assignment list
	 * 					Student project grade list size == Classroom project assignment list
	 * 					Student test grade list size == Classroom test assignment list
	 */
	public double getStudentOverallAverage(Student theStudent) {
		if (theStudent == null) {
			throw new IllegalArgumentException("Student cannot be null");
		}
		if (theStudent.getLabGradeList().size() != this.labAssignmentList.size()) {
			throw new IllegalArgumentException("Student lab grade list contains incorrect amount of grades earned");
		}
		if (theStudent.getProjectGradeList().size() != this.projectAssignmentList.size()) {
			throw new IllegalArgumentException("Student project grade list contains incorrect amount of grades earned");
		}
		if (theStudent.getTestGradeList().size() != this.testAssignmentList.size()) {
			throw new IllegalArgumentException("Student test grade list contains incorrect amount of grades earned");
		}
		return this.roundAverage((theStudent.getTotalLabPointsEarned() + theStudent.getTotalProjectPointsEarned() + theStudent.getTotalTestPointsEarned())
				/ (this.getTotalLabPointsPossible() + this.getTotalProjectPointsPossible() + this.getTotalTestPointsPossible()));
	}
	
	/**
	 * Returns the weighted average of the student's grades
	 * @param theStudent	The student whose average is being calculated
	 * @return	the weighted average of all grades for a student
	 */
	public double getStudentWeightedAverage(Student theStudent) {
		double weightedLab = (this.getStudentLabAverage(theStudent) / 100) * .2;
		double weightedProject = (this.getStudentProjectAverage(theStudent) / 100) * .35;
		double weightedTest = (this.getStudentTestAverage(theStudent) / 100) * .45;
		return this.roundAverage(weightedLab + weightedProject + weightedTest);
	}
	
	private double roundAverage(double average) {
		String averageString = String.format("%2.1f", (average * 100));
		return Double.parseDouble(averageString);
	}
}
