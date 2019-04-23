package edu.westga.cs6312.gradebook.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.westga.cs6312.gradebook.model.ClassroomData;
import edu.westga.cs6312.gradebook.model.Student;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

/**
 * Draws the GradeBook application GUI
 * @author Allen Pierson
 * @version 04232019
 *
 */
public class GradeBookPane extends Pane {
	private ClassroomData theClassroom;
	private FileReader theFileReader;
	private StringProperty studentNameProperty;
	
	/**
	 * 0-parameter constructor to instantiate the instance variable
	 */
	public GradeBookPane() {
		this.theClassroom = new ClassroomData();
		this.theFileReader = new FileReader();
		this.studentNameProperty = new SimpleStringProperty();
		this.setPaneSize();
		this.setPaneLayout();
	}
	
	private void setPaneSize() {
		this.setPrefSize(500, 600);
	}
	
	private void setPaneLayout() {
		BorderPane mainOverlay = new BorderPane();
		mainOverlay.prefWidthProperty().bind(this.widthProperty());
		mainOverlay.prefHeightProperty().bind(this.heightProperty());
		mainOverlay.setTop(this.setMenuBar());
		mainOverlay.setCenter(this.setStudentInformationContent());
		
		this.getChildren().add(mainOverlay);
	}
	
	private MenuBar setMenuBar() {
		MenuBar theMenuBar = new MenuBar();
		Menu file = new Menu("File");
		MenuItem open = new MenuItem("Open");
		open.setOnAction(openFile -> {
			File dataFile = this.theFileReader.chooseFile();
			this.theFileReader.readFile(dataFile);
		});
		file.getItems().add(open);
		
		Menu help = new Menu("Help");
		MenuItem about = new MenuItem("About");
		about.setOnAction(showAbout -> {
			this.showAboutBox();
		});
		help.getItems().add(about);
		
		theMenuBar.getMenus().addAll(file, help);
		return theMenuBar;
	}
	
	private Text setStudentInformationContent() {
		Text studentName = new Text("Please select a file.");
		this.studentNameProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentName.setText((String) newValue); 
            }
        });
		return studentName;
	}
	
	private void showAboutBox() {
		Alert applicationInformation = new Alert(AlertType.INFORMATION);
		applicationInformation.setTitle("CS6312 Allen Pierson Final Project");
		applicationInformation.setHeaderText(null);
		applicationInformation.setContentText("GradeBook Application by Allen Pierson (CS6312)");
		applicationInformation.showAndWait();
	}
	
	class FileReader {
		private FileChooser theFileChooser;
		
		FileReader() {
			this.theFileChooser = new FileChooser();
		}
		
		public File chooseFile() {
			File selectedFile = this.theFileChooser.showOpenDialog(null);
			if (selectedFile != null) {
				return selectedFile;
			} else {
				return null;
			}
		}
		
		public void readFile(File theFile) {
			try (Scanner inFile = new Scanner(theFile)) {
				String[] classData = inFile.nextLine().split(",");
				int assignmentType = 0;
				for (int current = 3; current < classData.length; current++) {
					if (classData[current].equals("")) {
						assignmentType++;
					} else {
						GradeBookPane.this.theClassroom.addAssignment(assignmentType, Double.valueOf(classData[current]));
					}
				}
				this.readStudentData(theFile);
			}  catch (InputMismatchException | IndexOutOfBoundsException | IllegalArgumentException exception) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Data Format error on line 1");
				alert.showAndWait();
			} catch (NullPointerException npe) {
				
			} catch (FileNotFoundException fnfe) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("The file could not be located or does not exist");
				alert.showAndWait();
			}
		}
		
		private void readStudentData(File theFile) throws FileNotFoundException {
			int gradeType = 0;
			int lineNumber = 2;
			try (Scanner inFile = new Scanner(theFile)) {
				while (inFile.hasNext()) {
					inFile.nextLine();
					try {
						GradeBookPane.this.theClassroom.getStudentList().clear();
						String[] studentData = inFile.nextLine().split(",");
						GradeBookPane.this.theClassroom.addStudent(Integer.valueOf(studentData[0]), studentData[1], studentData[2]);
						for (int current = 3; current < studentData.length; current++) {
							if (studentData[current].equals("")) {
								gradeType++;
							} else {
								GradeBookPane.this.theClassroom.getStudent(Integer.valueOf(studentData[0])).addGrade(gradeType, Double.valueOf(studentData[current]));
							}
						}
						lineNumber++;
						GradeBookPane.this.studentNameProperty.set(this.getStudent().getIdNumber() + " " + this.getStudent().getFirstName() + " " + this.getStudent().getLastName());
					} catch (InputMismatchException | IndexOutOfBoundsException | IllegalArgumentException exception) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setContentText("Data Format error on line " + lineNumber);
						alert.showAndWait();
					}
				}
			}
		}
		
		private Student getStudent() {
			return GradeBookPane.this.theClassroom.getStudentList().get(0);
		}
	}
}
