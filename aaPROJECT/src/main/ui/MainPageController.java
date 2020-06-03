package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// This class is the controller for MainPage
public class MainPageController extends BasicControlsMainMenu {
    @FXML
    private Button bmiButton;

    @FXML
    private TextField username;

    @FXML
    private Button goalsButton;

    @FXML
    private Text successfullySaved;

    @FXML
    private Button quit;

    @FXML
    private Text instructions;

    // Effects: sets the initial images and certain fields visibility to false
    @FXML
    public void initialize() {
        setInitialImages();
        username.setVisible(false);
        successfullySaved.setVisible(false);
        instructions.setVisible(false);
    }

    // Effects: Goes to bmiPage
    @FXML
    public void bmiClick() {
        goTo(bmiButton, "bmiPage");
    }

    // Effects: Goes to GoalsPage
    @FXML
    public void goalsClick() {
        goTo(goalsButton, "GoalsPage");
    }

    // Effects: sets the visibility of the username textField to on
    @FXML
    public void saveAccountClick() {
        username.setPromptText("Enter Username: ");
        username.setVisible(true);
        instructions.setVisible(true);
    }

    // Modifies: SaverAndLoader, BmiCalculator, ListOfGoals
    // Effects: saves the current bmi calculator and list of goals to the account specified by the user
    @FXML
    public void saveAccount(KeyEvent event) {
        String newUser;
        if (event.getCode().toString().equals("ENTER")) {
            newUser = username.getText();
            String bmiFileName = "./data/Bmi" + newUser + ".txt";
            String listOfGoalsFileName = "./data/Goals" + newUser + ".txt";
            try {
                App.get().getSaverAndLoader().save(App.get().getBmiCalculator(),
                        App.get().getListOfGoals(), bmiFileName, listOfGoalsFileName);
                successfullySaved.setVisible(true);
            } catch (Exception e) {
                System.out.println("error should not happen");
            }
        }
    }

    // Effects: Quits the program
    @FXML
    private void quitButtonAction() {
        Stage stage = (Stage) quit.getScene().getWindow();
        stage.close();
    }
}
