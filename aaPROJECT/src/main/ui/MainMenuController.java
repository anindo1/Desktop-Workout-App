package ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.sound.sampled.*;
import java.io.IOException;

// This class is the controller for the MainMenu
public class MainMenuController extends BasicControlsMainMenu {
    @FXML
    private TextField username;

    @FXML
    private MenuButton newAccountBar;

    @FXML
    private Text error;


    // Effects: Initializes the images and sets certain textFields to false visibility
    public void initialize() {
        username.setVisible(false);
        setInitialImages();
        error.setVisible(false);
    }

    // Effects: Plays an audio sound of a lion roar and then changes scene to MainPage
    @FXML
    public void newAccount() throws IOException {
        playAudio();
        AnchorPane mainPage = (AnchorPane) FXMLLoader.load(getClass().getResource("MainPage.fxml"));

        Stage window = (Stage) newAccountBar.getScene().getWindow();
        window.setScene(new Scene(mainPage));
        window.show();
    }

    // Effects: Plays an audio
    @FXML
    public void playAudio() {
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Main.class.getResourceAsStream("Roar.wav"));
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("this error will nver happen lmaoo");
        }
    }

    // Effects: Sets the username visibility to true and shows a prompt text
    @FXML
    public void loadAccountAction() {
        username.setPromptText("Enter Username:");
        username.setVisible(true);
    }

    // Modifies: SaverAndLoader, ListOfGoals, BmiCalculator
    // Effects: Loads an account with a BmiCalculator and ListOfGoals
    //          If account name is not found, displays an error message and does nothing
    @FXML
    public void loadAccount(KeyEvent event) {
        String user;
        if (event.getCode().toString().equals("ENTER")) {
            user = username.getText();
            String bmiFileName = "./data/Bmi" + user + ".txt";
            String listOfGoalsFileName = "./data/Goals" + user + ".txt";
            try {
                App.get().getSaverAndLoader().load(bmiFileName, listOfGoalsFileName);
                App.get().bmiCalculator = App.get().getSaverAndLoader().getBmiCalculator();
                App.get().listOfGoals = App.get().getSaverAndLoader().getListOfGoals();

                Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                Stage window = App.get().primaryStage;
                window.setScene(new Scene(root));
                window.show();
                window.setResizable(false);
                playAudio();

                error.setVisible(false);
            } catch (Exception e) {
                error.setVisible(true);
            }
        }
    }
}
