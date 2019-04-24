package edu.westga.cs6312.gradebook.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.westga.cs6312.gradebook.model.ClassroomData;
import edu.westga.cs6312.gradebook.model.Student;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
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
	private StringProperty studentLabAverageProperty;
	private StringProperty studentProjectAverageProperty;
	private StringProperty studentTestAverageProperty;
	private StringProperty studentOverallAverageProperty;
	
	/**
	 * 0-parameter constructor to instantiate the instance variable
	 */
	public GradeBookPane() {
		this.theClassroom = new ClassroomData();
		this.theFileReader = new FileReader();
		this.studentNameProperty = new SimpleStringProperty();
		this.studentLabAverageProperty = new SimpleStringProperty();
		this.studentProjectAverageProperty = new SimpleStringProperty();
		this.studentTestAverageProperty = new SimpleStringProperty();
		this.studentOverallAverageProperty = new SimpleStringProperty();
		this.setPaneSize();
		this.setPaneLayout();
	}
	
	private void setPaneSize() {
		this.setPrefSize(500, 350);
	}
	
	private void setPaneLayout() {
		BorderPane mainOverlay = new BorderPane();
		mainOverlay.prefWidthProperty().bind(this.widthProperty());
		mainOverlay.prefHeightProperty().bind(this.heightProperty());
		mainOverlay.setTop(this.setMenuBar());
		mainOverlay.setCenter(this.setStudentInformationContent());
		VBox bottomContent = this.showStudentAverages();
		BorderPane.setAlignment(bottomContent, Pos.TOP_CENTER);
		mainOverlay.setBottom(bottomContent);
		
		this.getChildren().add(mainOverlay);
	}
	
	private MenuBar setMenuBar() {
		MenuBar theMenuBar = new MenuBar();
		Menu file = new Menu("_File");
		MenuItem open = new MenuItem("Open");
		open.setOnAction(openFile -> {
			File dataFile = this.theFileReader.chooseFile();
			this.theFileReader.readFile(dataFile);
		});
		open.setAccelerator(new KeyCodeCombination(KeyCode.O,  KeyCombination.CONTROL_DOWN));
		file.getItems().add(open);
		
		Menu help = new Menu("_Help");
		MenuItem about = new MenuItem("About");
		about.setOnAction(showAbout -> {
			this.showAboutBox();
		});
		about.setAccelerator(new KeyCodeCombination(KeyCode.I,  KeyCombination.CONTROL_DOWN));
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
		studentName.setFont(Font.font("Verdana", 30));
		return studentName;
	}
	
	private void showAboutBox() {
		Alert applicationInformation = new Alert(AlertType.INFORMATION);
		applicationInformation.setTitle("CS6312 Allen Pierson Final Project");
		applicationInformation.setHeaderText(null);
		applicationInformation.setContentText("GradeBook Application by Allen Pierson (CS6312)");
		applicationInformation.showAndWait();
	}
	
	private VBox showStudentAverages() {
		VBox averageData = new VBox();
		Text studentLab = this.setStudentLabAverage();
		Text studentProject = this.setStudentProjectAverage();
		Text studentTest = this.setStudentTestAverage();
		Text studentOverall = this.setStudentOverallAverage();
		averageData.setSpacing(15);
		averageData.setPadding(new Insets(0, 0, 15, 15));
		
		averageData.getChildren().addAll(studentLab, studentProject, studentTest, studentOverall);
		return averageData;
	}
	
	private Text setStudentLabAverage() {
		Text studentLabAverage = new Text("");
		this.studentLabAverageProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentLabAverage.setText((String) newValue); 
        	}
        });
		studentLabAverage.setFont(Font.font("Verdana", 20));
		return studentLabAverage;
	}
	
	private Text setStudentProjectAverage() {
		Text studentProjectAverage = new Text("");
		this.studentProjectAverageProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentProjectAverage.setText((String) newValue); 
        	}
        });
		studentProjectAverage.setFont(Font.font("Verdana", 20));
		return studentProjectAverage;
	}
	
	private Text setStudentTestAverage() {
		Text studentTestAverage = new Text("");
		this.studentTestAverageProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentTestAverage.setText((String) newValue); 
        	}
        });
		studentTestAverage.setFont(Font.font("Verdana", 20));
		return studentTestAverage;
	}
	
	private Text setStudentOverallAverage() {
		Text studentOverallAverage = new Text("");
		this.studentOverallAverageProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentOverallAverage.setText((String) newValue); 
        	}
        });
		studentOverallAverage.setFont(Font.font("Verdana", 20));
		return studentOverallAverage;
	}
	
	private Student getStudent() {
		return GradeBookPane.this.theClassroom.getStudentList().get(0);
	}
	
	class FileReader {
		private FileChooser theFileChooser;
		
		FileReader() {
			this.theFileChooser = new FileChooser();
			this.theFileChooser.getExtensionFilters().addAll(
			        new FileChooser.ExtensionFilter("Plaintext files", "*.txt"),
			        new FileChooser.ExtensionFilter("All files", "*.*"));
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
				GradeBookPane.this.theClassroom.getLabAssignmentList().clear();
				GradeBookPane.this.theClassroom.getProjectAssignmentList().clear();
				GradeBookPane.this.theClassroom.getTestAssignmentList().clear();
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
				Alert alert = new Alert(AlertType.WARNING);
				alert.setContentText("Data Format error on line 1");
				alert.showAndWait();
			} catch (NullPointerException npe) {
				
			} catch (FileNotFoundException | NoSuchElementException exception) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Incorrect file selection.");
				alert.showAndWait();
			}
		}
		
		private void readStudentData(File theFile) throws FileNotFoundException {
			int gradeType = 0;
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
						GradeBookPane.this.studentNameProperty.set(GradeBookPane.this.getStudent().getIdNumber() + " " + GradeBookPane.this.getStudent().getFirstName() + " " + GradeBookPane.this.getStudent().getLastName());
						GradeBookPane.this.studentLabAverageProperty.set(String.valueOf("Lab average: " + GradeBookPane.this.theClassroom.getStudentLabAverage(GradeBookPane.this.getStudent())));
						GradeBookPane.this.studentProjectAverageProperty.set(String.valueOf("Project average: " + GradeBookPane.this.theClassroom.getStudentProjectAverage(GradeBookPane.this.getStudent())));
						GradeBookPane.this.studentTestAverageProperty.set(String.valueOf("Test average: " + GradeBookPane.this.theClassroom.getStudentTestAverage(GradeBookPane.this.getStudent())));
						GradeBookPane.this.studentOverallAverageProperty.set(String.valueOf("Overall average: " + GradeBookPane.this.theClassroom.getStudentOverallAverage(GradeBookPane.this.getStudent())));
					} catch (InputMismatchException | IndexOutOfBoundsException | IllegalArgumentException exception) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setContentText("Data error: " + exception.getMessage());
						alert.showAndWait();
					}
				}
			}
		}
	}
}
