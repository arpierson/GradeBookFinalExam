package edu.westga.cs6312.gradebook.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.westga.cs6312.gradebook.model.ClassroomData;
import edu.westga.cs6312.gradebook.model.Student;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
	private StringProperty studentWeightedAverageProperty;
	private ObjectProperty<Student> currentStudentProperty;
	private ObjectProperty<ArrayList<Student>> studentRosterProperty;
	//Look into using currentStudentProperty to get stringProperties above
	
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
		this.studentWeightedAverageProperty = new SimpleStringProperty();
		this.currentStudentProperty = new SimpleObjectProperty<Student>(this.theClassroom.getCurrentStudent());
		this.studentRosterProperty = new SimpleObjectProperty<ArrayList<Student>>();
		this.setPaneSize();
		this.setPaneLayout();
	}
	
	private void setPaneSize() {
		this.setPrefSize(800, 650);
	}
	
	private void setPaneLayout() {
		BorderPane mainOverlay = new BorderPane();
		mainOverlay.prefWidthProperty().bind(this.widthProperty());
		mainOverlay.prefHeightProperty().bind(this.heightProperty());
		mainOverlay.setTop(this.setTopOfPane());
		mainOverlay.setCenter(this.setBarGraph());
		VBox bottomContent = this.showStudentAverages();
		BorderPane.setAlignment(bottomContent, Pos.TOP_CENTER);
		mainOverlay.setBottom(bottomContent);
		
		this.getChildren().add(mainOverlay);
	}
	
	private MenuBar setMenuBar() {
		MenuBar theMenuBar = new MenuBar();
		Menu file = new Menu("_File");
		file.setMnemonicParsing(true);
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
		about.setMnemonicParsing(true);
		theMenuBar.getMenus().addAll(file, help);
		return theMenuBar;
	}
	
	private void showAboutBox() {
		Alert applicationInformation = new Alert(AlertType.INFORMATION);
		applicationInformation.setTitle("CS6312 Allen Pierson Final Project");
		applicationInformation.setHeaderText(null);
		applicationInformation.setContentText("GradeBook Application by Allen Pierson (CS6312)");
		applicationInformation.showAndWait();
	}
	
	private ComboBox<Student> setSelectStudentMenu() {
		ComboBox<Student> studentNameBox = new ComboBox<Student>();
		this.studentRosterProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
            	for (Student current : GradeBookPane.this.theClassroom.getStudentList()) {
            		studentNameBox.getItems().add(current);
            		studentNameBox.setValue(GradeBookPane.this.getCurrentStudent());
            	}
            }
        });
		studentNameBox.setOnAction(studentSelect -> {
			GradeBookPane.this.theClassroom.setCurrentStudent(studentNameBox.getValue());
			GradeBookPane.this.currentStudentProperty.set(studentNameBox.getValue());
		});
		return studentNameBox;
	}
	
	private Text setWelcomeMessage() {
		Text studentName = new Text("Please select a text file.");
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentName.setText(""); 
            }
        });
		studentName.setFont(Font.font("Verdana", 30));
		return studentName;
	}
	
	private HBox setStudentInformationContent() {
		HBox studentContentBox = new HBox();
		studentContentBox.setSpacing(30);
		studentContentBox.getChildren().addAll(this.setSelectStudentMenu(), this.setWelcomeMessage());
		return studentContentBox;
	}
	
	private VBox setTopOfPane() {
		VBox topContentBox = new VBox();
		HBox studentNameBox = new HBox();
		studentNameBox.setPadding(new Insets(10, 0, 10, 20));
		HBox studentInformation = this.setStudentInformationContent();
		studentNameBox.getChildren().add(studentInformation);
		topContentBox.getChildren().addAll(this.setMenuBar(), studentNameBox);
		return topContentBox;
	}
	
	private BarChart<String, Number> setBarGraph() {
		CategoryAxis xAxis = new CategoryAxis();
		xAxis.setLabel("Grade Categories");
		NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("Grade Averages");
		yAxis.setAutoRanging(false);
		yAxis.setTickUnit(10);
		yAxis.setMinorTickVisible(false);
		yAxis.setUpperBound(100);
		yAxis.setLowerBound(0);
		BarChart<String, Number> averageChart = new BarChart<String, Number>(xAxis, yAxis);
		averageChart.setAnimated(false);
		
		XYChart.Series<String, Number> labData = this.getLabBar();
		XYChart.Series<String, Number> projectData = this.getProjectsBar();
		XYChart.Series<String, Number> testData = this.getTestBar();
		XYChart.Series<String, Number> overallStraight = this.getStraightAverageBar();
		XYChart.Series<String, Number> overallWeighted = this.getWeightedAverageBar();
		
		averageChart.getData().add(labData);
		averageChart.getData().add(projectData);
		averageChart.getData().add(testData);
		averageChart.getData().add(overallStraight);
		averageChart.getData().add(overallWeighted);
		averageChart.setPadding(new Insets(0, 10, 15, 10));
		return averageChart;
	}
	
	private XYChart.Series<String, Number> getLabBar() {
		XYChart.Series<String, Number> labData = new XYChart.Series<String, Number>();
		labData.setName("Labs");
		labData.getData().add(new XYChart.Data<String, Number>(String.valueOf(0), 0));
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
            	if (newValue.equals("")) {
            		labData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(0), 0));
            	} else {
            		labData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(GradeBookPane.this.theClassroom.getStudentLabAverage()), GradeBookPane.this.theClassroom.getStudentLabAverage()));
            	}
        	}
        });
		return labData;
	}
	
	private XYChart.Series<String, Number> getProjectsBar() {
		XYChart.Series<String, Number> projectData = new XYChart.Series<String, Number>();
		projectData.setName("Projects");
		projectData.getData().add(new XYChart.Data<String, Number>(String.valueOf(0), 0));
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
            	if (newValue.equals("")) {
            		projectData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(0), 0));
            	} else {
            		projectData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(GradeBookPane.this.theClassroom.getStudentProjectAverage()), GradeBookPane.this.theClassroom.getStudentProjectAverage()));
            	}
        	}
        });
		return projectData;
	}
	
	private XYChart.Series<String, Number> getTestBar() {
		XYChart.Series<String, Number> testData = new XYChart.Series<String, Number>();
		testData.setName("Tests");
		testData.getData().add(new XYChart.Data<String, Number>(String.valueOf(0), 0));
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
            	if (newValue.equals("")) {
            		testData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(0), 0));
            	} else {
            		testData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(GradeBookPane.this.theClassroom.getStudentTestAverage()), GradeBookPane.this.theClassroom.getStudentTestAverage()));
            	}
        	}
        });
		return testData;
	}
	
	private XYChart.Series<String, Number> getStraightAverageBar() {
		XYChart.Series<String, Number> straightData = new XYChart.Series<String, Number>();
		straightData.setName("Straight Average");
		straightData.getData().add(new XYChart.Data<String, Number>(String.valueOf(0), 0));
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
            	if (newValue.equals("")) {
            		straightData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(0), 0));
            	} else {
            		straightData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(GradeBookPane.this.theClassroom.getStudentOverallAverage()), GradeBookPane.this.theClassroom.getStudentOverallAverage()));
            	}
        	}
        });
		return straightData;
	}
	
	private XYChart.Series<String, Number> getWeightedAverageBar() {
		XYChart.Series<String, Number> weightedData = new XYChart.Series<String, Number>();
		weightedData.setName("Weighted Average");
		weightedData.getData().add(new XYChart.Data<String, Number>(String.valueOf(0), 0));
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
            	if (newValue.equals("")) {
            		weightedData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(0), 0));
            	} else {
            		weightedData.getData().set(0, new XYChart.Data<String, Number>(String.valueOf(GradeBookPane.this.theClassroom.getStudentWeightedAverage()), GradeBookPane.this.theClassroom.getStudentWeightedAverage()));
            	}
        	}
        });
		return weightedData;
	}
	
	private VBox showStudentAverages() {
		VBox averageData = new VBox();
		HBox studentLab = this.setStudentLabAverage();
		HBox studentProject = this.setStudentProjectAverage();
		HBox studentTest = this.setStudentTestAverage();
		HBox studentOverall = this.setStudentOverallAverage();
		HBox studentWeighted = this.setStudentWeightedAverage();
		averageData.setSpacing(15);
		averageData.setPadding(new Insets(0, 0, 15, 15));
		
		averageData.getChildren().addAll(studentLab, studentProject, studentTest, studentOverall, studentWeighted);
		return averageData;
	}
	
	private HBox setStudentLabAverage() {
		HBox labBox = new HBox();
		Label labLabel = new Label("Lab average: ");
		Text studentLabAverage = new Text("");
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentLabAverage.setText(String.valueOf(GradeBookPane.this.theClassroom.getStudentLabAverage())); 
        	}
        });
		labLabel.setFont(Font.font("Verdana", 15));
		studentLabAverage.setFont(Font.font("Verdana", 15));
		labBox.getChildren().addAll(labLabel, studentLabAverage);
		return labBox;
	}
	
	private HBox setStudentProjectAverage() {
		HBox projectBox = new HBox();
		Label projectLabel = new Label("Project average: ");
		Text studentProjectAverage = new Text("");
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentProjectAverage.setText(String.valueOf(GradeBookPane.this.theClassroom.getStudentProjectAverage())); 
        	}
        });
		projectLabel.setFont(Font.font("Verdana", 15));
		studentProjectAverage.setFont(Font.font("Verdana", 15));
		projectBox.getChildren().addAll(projectLabel, studentProjectAverage);
		return projectBox;
	}
	
	private HBox setStudentTestAverage() {
		HBox testBox = new HBox();
		Label testLabel = new Label("Test average: ");
		Text studentTestAverage = new Text("");
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentTestAverage.setText(String.valueOf(GradeBookPane.this.theClassroom.getStudentTestAverage())); 
        	}
        });
		testLabel.setFont(Font.font("Verdana", 15));
		studentTestAverage.setFont(Font.font("Verdana", 15));
		testBox.getChildren().addAll(testLabel, studentTestAverage);
		return testBox;
	}
	
	private HBox setStudentOverallAverage() {
		HBox straightAverageBox = new HBox();
		Label straightAverageLabel = new Label("Straight average: ");
		Text studentOverallAverage = new Text("");
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentOverallAverage.setText(String.valueOf(GradeBookPane.this.theClassroom.getStudentOverallAverage())); 
        	}
        });
		straightAverageLabel.setFont(Font.font("Verdana", 15));
		studentOverallAverage.setFont(Font.font("Verdana", 15));
		straightAverageBox.getChildren().addAll(straightAverageLabel, studentOverallAverage);
		return straightAverageBox;
	}
	
	private HBox setStudentWeightedAverage() {
		HBox weightedAverageBox = new HBox();
		Label weightedAverageLabel = new Label("Weighted average: ");
		Text studentWeightedAverage = new Text("");
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                studentWeightedAverage.setText(String.valueOf(GradeBookPane.this.theClassroom.getStudentWeightedAverage())); 
        	}
        });
		weightedAverageLabel.setFont(Font.font("Verdana", 15));
		studentWeightedAverage.setFont(Font.font("Verdana", 15));
		weightedAverageBox.getChildren().addAll(weightedAverageLabel, studentWeightedAverage);
		return weightedAverageBox;
	}
	
	private Student getCurrentStudent() {
		Student currentStudent = this.theClassroom.getCurrentStudent();
		this.currentStudentProperty.addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
            	GradeBookPane.this.theClassroom.setCurrentStudent((Student) newValue);
        	}
        });
		return currentStudent;
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
				GradeBookPane.this.theClassroom.getStudentList().clear();
				this.readStudentData(theFile);
			}  catch (InputMismatchException | IndexOutOfBoundsException | IllegalArgumentException exception) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setContentText("Data Format error on line 1" + exception.getMessage());
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
			int currentStudentIndex = 0;
			try (Scanner inFile = new Scanner(theFile)) {
				inFile.nextLine();
				while (inFile.hasNext()) {
					try {
						String[] studentData = inFile.nextLine().toUpperCase().split(",");
						GradeBookPane.this.theClassroom.addStudent(Integer.valueOf(studentData[0]), studentData[1], studentData[2]);
						GradeBookPane.this.theClassroom.setCurrentStudent(GradeBookPane.this.theClassroom.getStudentList().get(currentStudentIndex));
						for (int current = 3; current < studentData.length; current++) {
							if (studentData[current].equals("")) {
								gradeType++;
							} else {
								GradeBookPane.this.getCurrentStudent().addGrade(gradeType, Double.valueOf(studentData[current]));
							}
						}
						currentStudentIndex++;
						gradeType = 0;
					} catch (InputMismatchException | IndexOutOfBoundsException | IllegalArgumentException exception) {
						Alert alert = new Alert(AlertType.WARNING);
						alert.setContentText("Data error: " + exception.getMessage());
						alert.showAndWait();
						this.clearAverages();
					}
				}
			}
			Collections.sort(GradeBookPane.this.theClassroom.getStudentList());
			this.setStudentProperties();
		}
		
		private void setStudentProperties() {
			GradeBookPane.this.studentNameProperty.set(GradeBookPane.this.getCurrentStudent().getIdNumber() + " " + GradeBookPane.this.getCurrentStudent().getFirstName() + " " + GradeBookPane.this.getCurrentStudent().getLastName());
			GradeBookPane.this.studentLabAverageProperty.set(String.valueOf(GradeBookPane.this.theClassroom.getStudentLabAverage()));
			GradeBookPane.this.studentProjectAverageProperty.set(String.valueOf(GradeBookPane.this.theClassroom.getStudentProjectAverage()));
			GradeBookPane.this.studentTestAverageProperty.set(String.valueOf(GradeBookPane.this.theClassroom.getStudentTestAverage()));
			GradeBookPane.this.studentOverallAverageProperty.set(String.valueOf(GradeBookPane.this.theClassroom.getStudentOverallAverage()));
			GradeBookPane.this.studentWeightedAverageProperty.set(String.valueOf(GradeBookPane.this.theClassroom.getStudentWeightedAverage()));
			GradeBookPane.this.studentRosterProperty.set(GradeBookPane.this.theClassroom.getStudentList());
			GradeBookPane.this.currentStudentProperty.set(GradeBookPane.this.theClassroom.getCurrentStudent());
		}

		private void clearAverages() {
			GradeBookPane.this.studentNameProperty.set("Please select a file.");
			GradeBookPane.this.studentLabAverageProperty.set("");
			GradeBookPane.this.studentProjectAverageProperty.set("");
			GradeBookPane.this.studentTestAverageProperty.set("");
			GradeBookPane.this.studentOverallAverageProperty.set("");
			GradeBookPane.this.studentWeightedAverageProperty.set("");
		}
	}
}
