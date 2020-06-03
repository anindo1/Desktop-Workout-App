package ui;

import javafx.stage.Stage;
import model.BmiCalculator;
import model.ListOfGoals;
import persistance.SaverAndLoader;

// This class is used to create a singleton class instance so that my controllers can have access to a bmi calculator
// and list of goals from anywhere.

public class App {
    public static App instance;
    public BmiCalculator bmiCalculator;
    public ListOfGoals listOfGoals;
    public SaverAndLoader saverAndLoader;

    public Stage primaryStage;
    
    public static void init(Stage stage) {
        instance = new App(stage);
    }
    
    public static App get() {
        return instance;
    }

    // Effects: Constructor
    public App(Stage stage) {
        primaryStage = stage;
        bmiCalculator = new BmiCalculator();
        listOfGoals = new ListOfGoals();
        saverAndLoader = new SaverAndLoader();
    }

    public BmiCalculator getBmiCalculator() {
        return bmiCalculator;
    }

    public ListOfGoals getListOfGoals() {
        return listOfGoals;
    }

    public SaverAndLoader getSaverAndLoader() {
        return saverAndLoader;
    }
    
    
}
