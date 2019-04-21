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
	private ArrayList<Double> assignmentList;
	
	/**
	 * 0-parameter constructor to instantiate the instance variables
	 */
	public ClassroomData() {
		this.studentList = new ArrayList<Student>();
		this.assignmentList = new ArrayList<Double>();
	}
}
