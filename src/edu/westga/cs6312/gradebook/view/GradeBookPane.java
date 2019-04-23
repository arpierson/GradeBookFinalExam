package edu.westga.cs6312.gradebook.view;

import java.io.File;

import edu.westga.cs6312.gradebook.model.ClassroomData;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
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
	
	private void setPaneSize() {
		this.setPrefSize(500, 600);
	}
	
	private void setPaneLayout() {
		BorderPane mainOverlay = new BorderPane();
		mainOverlay.prefWidthProperty().bind(this.widthProperty());
		mainOverlay.prefHeightProperty().bind(this.heightProperty());
		mainOverlay.setTop(this.setMenuBar());
		
		this.getChildren().add(mainOverlay);
	}
	
	private MenuBar setMenuBar() {
		MenuBar theMenuBar = new MenuBar();
		Menu file = new Menu("File");
		MenuItem open = new MenuItem("Open");
		open.setOnAction(openFile -> {
			File dataFile = this.fileReader.chooseFile();
			this.fileReader.setAssignmentPointsPossible(dataFile);
		});
		file.getItems().add(open);
		
		Menu about = new Menu("About");
		MenuItem help = new MenuItem("Help");
		about.getItems().add(help);
		
		theMenuBar.getMenus().addAll(file, about);
		return theMenuBar;
	}
}
