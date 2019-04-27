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
	private Student currentStudent;
	
	/**
	 * 0-parameter constructor to instantiate the instance variables
	 */
	public ClassroomData() {
		this.labAssignmentList = new ArrayList<Double>();
		this.projectAssignmentList = new ArrayList<Double>();
		this.testAssignmentList = new ArrayList<Double>();
		this.studentList = new ArrayList<Student>();
		this.currentStudent = null;
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
	 * Sets the current student in the classroom
	 * @param theStudent	the current student
	 */
	public void setCurrentStudent(Student theStudent) {
		if (theStudent == null) {
			throw new IllegalArgumentException("Student cannot be null");
		}
		this.currentStudent = theStudent;
	}
	
	/**
	 * Returns the current student
	 * @return	the current student
	 */
	public Student getCurrentStudent() {
		return this.currentStudent;
	}
	
	/**
	 * Returns straight average of lab grades for a student
	 * @return	straight average of lab grades for a student
	 * 
	 * Preconditions:	Student lab grade list size == Classroom lab assignment list
	 */
	public double getStudentLabAverage() {
		if (this.currentStudent.getLabGradeList().size() != this.labAssignmentList.size()) {
			throw new IllegalArgumentException("Student lab grade list contains incorrect amount of grades earned");
		}
		return this.roundAverage(this.currentStudent.getTotalLabPointsEarned() / this.getTotalLabPointsPossible());
	}
	
	/**
	 * Returns straight average of project grades for a student
	 * @return	straight average of project grades for a student
	 * 
	 * Preconditions:	Student project grade list size == Classroom project assignment list
	 */
	public double getStudentProjectAverage() {
		if (this.currentStudent.getProjectGradeList().size() != this.projectAssignmentList.size()) {
			throw new IllegalArgumentException("Student project grade list contains incorrect amount of grades earned");
		}
		return this.roundAverage(this.currentStudent.getTotalProjectPointsEarned() / this.getTotalProjectPointsPossible());
	}
	
	/**
	 * Returns straight average of test grades for a student
	 * @return	straight average of test grades for a student
	 * 
	 * Preconditions:	Student test grade list size == Classroom test assignment list
	 */
	public double getStudentTestAverage() {
		if (this.currentStudent.getTestGradeList().size() != this.testAssignmentList.size()) {
			throw new IllegalArgumentException("Student test grade list contains incorrect amount of grades earned");
		}
		return this.roundAverage(this.currentStudent.getTotalTestPointsEarned() / this.getTotalTestPointsPossible());
	}
	
	/**
	 * Returns the straight average of all grades for a student
	 * @return	the straight average of all grades for a student
	 * 
	 * Preconditions:	Student lab grade list size == Classroom lab assignment list
	 * 					Student project grade list size == Classroom project assignment list
	 * 					Student test grade list size == Classroom test assignment list
	 */
	public double getStudentOverallAverage() {
		if (this.currentStudent.getLabGradeList().size() != this.labAssignmentList.size()) {
			throw new IllegalArgumentException("Student lab grade list contains incorrect amount of grades earned");
		}
		if (this.currentStudent.getProjectGradeList().size() != this.projectAssignmentList.size()) {
			throw new IllegalArgumentException("Student project grade list contains incorrect amount of grades earned");
		}
		if (this.currentStudent.getTestGradeList().size() != this.testAssignmentList.size()) {
			throw new IllegalArgumentException("Student test grade list contains incorrect amount of grades earned");
		}
		return this.roundAverage((this.currentStudent.getTotalLabPointsEarned() + this.currentStudent.getTotalProjectPointsEarned() + this.currentStudent.getTotalTestPointsEarned())
				/ (this.getTotalLabPointsPossible() + this.getTotalProjectPointsPossible() + this.getTotalTestPointsPossible()));
	}
	
	/**
	 * Returns the weighted average of the student's grades
	 * @return	the weighted average of all grades for a student
	 */
	public double getStudentWeightedAverage() {
		double weightedLab = (this.getStudentLabAverage() / 100) * .2;
		double weightedProject = (this.getStudentProjectAverage() / 100) * .35;
		double weightedTest = (this.getStudentTestAverage() / 100) * .45;
		return this.roundAverage(weightedLab + weightedProject + weightedTest);
	}
	
	/**
	 * Returns the class lab average
	 * @return	the class lab average
	 */
	public double getClassLabAverage() {
		Student temporaryStudent = this.getCurrentStudent();
		double averageTotal = 0;
		for (Student current : this.getStudentList()) {
			this.setCurrentStudent(current);
			averageTotal += this.getStudentLabAverage();
		}
		this.setCurrentStudent(temporaryStudent);
		return this.roundAverage(averageTotal / this.getStudentList().size() / 100);
	}
	
	/**
	 * Returns the class project average
	 * @return	the class project average
	 */
	public double getClassProjectAverage() {
		Student temporaryStudent = this.getCurrentStudent();
		double averageTotal = 0;
		for (Student current : this.getStudentList()) {
			this.setCurrentStudent(current);
			averageTotal += this.getStudentProjectAverage();
		}
		this.setCurrentStudent(temporaryStudent);
		return this.roundAverage(averageTotal / this.getStudentList().size() / 100);
	}
	
	/**
	 * Returns the class test average
	 * @return	the class test average
	 */
	public double getClassTestAverage() {
		Student temporaryStudent = this.getCurrentStudent();
		double averageTotal = 0;
		for (Student current : this.getStudentList()) {
			this.setCurrentStudent(current);
			averageTotal += this.getStudentTestAverage();
		}
		this.setCurrentStudent(temporaryStudent);
		return this.roundAverage(averageTotal / this.getStudentList().size() / 100);
	}

	/**
	 * Returns the class overall average
	 * @return	the class overall average
	 */
	public double getClassOverallAverage() {
		Student temporaryStudent = this.getCurrentStudent();
		double averageTotal = 0;
		for (Student current : this.getStudentList()) {
			this.setCurrentStudent(current);
			averageTotal += this.getStudentOverallAverage();
		}
		this.setCurrentStudent(temporaryStudent);
		return this.roundAverage(averageTotal / this.getStudentList().size() / 100);
	}
	
	private double roundAverage(double average) {
		String averageString = String.format("%2.1f", (average * 100));
		return Double.parseDouble(averageString);
	}
}
