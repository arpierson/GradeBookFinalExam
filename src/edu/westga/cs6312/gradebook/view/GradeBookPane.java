package edu.westga.cs6312.gradebook.view;

import edu.westga.cs6312.gradebook.model.ClassroomData;
import javafx.scene.layout.Pane;

/**
 * Draws the GradeBook application GUI
 * @author Allen Pierson
 * @version 04232019
 *
 */
public class GradeBookPane extends Pane {
	private ClassroomData theClassroom;
	
	/**
	 * 0-parameter constructor to instantiate the instance variable
	 */
	public GradeBookPane() {
		this.theClassroom = new ClassroomData();
	}
}
