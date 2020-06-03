package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

// This class is the controller for the bmiPage
public class BmiController extends BasicControlsBmi {
    @FXML
    private Button mainMenu;

    @FXML
    private MenuButton calcBmiButton;

    @FXML
    private Text bmiText;

    @FXML
    private Text statusText;

    @FXML
    private Text bmiVal;

    @FXML
    private Text statusVal;

    // Effects: initializes the images and sets some fields visibility to false
    @FXML
    public void initialize() {
        setInitialImages();
        bmiText.setVisible(false);
        statusText.setVisible(false);
        bmiVal.setVisible(false);
        statusVal.setVisible(false);
    }

    // Effects: sets the bmi's visibility to on and shows the current registered BMI
    @FXML
    public void viewBMI() {
        bmiImage.setVisible(true);

        bmiVal.setText(Double.toString(App.get().getBmiCalculator().getBmi()));
        String userStatus = status(App.get().getBmiCalculator().getBmi());
        statusVal.setText(userStatus);

        statusText.setVisible(true);
        bmiVal.setVisible(true);
        bmiText.setVisible(true);
        statusVal.setVisible(true);
    }

    // Effects: Goes to MetricBmi page
    @FXML
    public void goToMetric() {
        menuButtonGoTo(calcBmiButton, "MetricBmi");
    }

    // Effects: Goes to ImperialBmi page
    @FXML
    public void goToImperial() {
        menuButtonGoTo(calcBmiButton, "ImperialBmi");
    }

    // Effects: Goes back to MainPage
    @FXML
    public void back() {
        goTo(mainMenu, "MainPage");
    }

}
