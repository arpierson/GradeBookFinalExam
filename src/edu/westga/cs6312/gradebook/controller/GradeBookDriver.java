package edu.westga.cs6312.gradebook.controller;

import edu.westga.cs6312.gradebook.view.GradeBookPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Calls the GUI to run the application
 * @author Allen Pierson
 * @version 04232019
 *
 */
public class GradeBookDriver extends Application {
	@Override
	public void start(Stage primaryStage) {
		GradeBookPane pane = new GradeBookPane();
		Scene theScene = new Scene(pane);
		primaryStage.setTitle("CS6312 Allen Pierson Final Project");
		primaryStage.setScene(theScene);
		primaryStage.show();
	}
	
	/**
	 * This method is the entry point of the application
	 *
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
