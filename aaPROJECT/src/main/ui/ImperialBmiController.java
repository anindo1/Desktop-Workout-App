package ui;

import exceptions.NotPositiveException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

// This class is the controller for ImperialBmi
public class ImperialBmiController extends BasicControlsBmi {
    @FXML
    private Button mainMenu;

    @FXML
    private Button backButton;

    @FXML
    private Button calculateBmiButton;

    @FXML
    private Text error;

    @FXML
    private Text bmiText;

    @FXML
    private Text statusText;

    @FXML
    private TextField heightFt;

    @FXML
    private TextField heightInch;

    @FXML
    private TextField weight;

    // Initializes the pictures and sets the error message's visibility to false
    @FXML
    public void initialize() {
        setInitialImages();
        error.setVisible(false);
    }

    // Effects: Goes to the MainPage
    @FXML
    public void goToMainMenu() {
        goTo(mainMenu, "MainPage");
    }

    // Effects: Goes back to bmiPage
    @FXML
    public void goBack() {
        goTo(backButton, "bmiPage");
    }

    // Modifies: BmiCalculator
    // Effects: calculates the user's bmi given the inputs and displays the bmi along with the status
    //          If the user's bmi cannot be calculated due to improper inputs, an error message is displayed
    @FXML
    public void calculateBmi() {
        try {
            double wght = Double.parseDouble(weight.getText());
            double htFt = Double.parseDouble(heightFt.getText());
            double htIn = Double.parseDouble(heightInch.getText());
            double bmi = App.get().getBmiCalculator().bmiImperial(wght, htFt, htIn);
            App.get().getBmiCalculator().setBmiRounded(bmi);
            bmiText.setText(Double.toString(App.get().getBmiCalculator().getBmi()));
            String userStatus = status(App.get().getBmiCalculator().getBmi());
            statusText.setText(userStatus);
            error.setVisible(false);
        } catch (NotPositiveException e) {
            error.setVisible(true);
        }
    }
}
