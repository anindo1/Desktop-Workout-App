package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

// This is an abstract class that every FXML Controller class uses, as it has universal methods that all these classes
// call

public abstract class BasicControlsUniversal {

    // Effects: Goes to a new page given a normal button and page
    public void goTo(Button button, String page) {
        try {
            AnchorPane mainPage = (AnchorPane) FXMLLoader.load(getClass().getResource(page + ".fxml"));

            Stage window = (Stage) button.getScene().getWindow();
            window.setScene(new Scene(mainPage));
            window.show();
        } catch (IOException e) {
            System.out.println("oh no Io exception!");
        }
    }

    // Effects: Goes to a new page given a menu button and page
    public void menuButtonGoTo(MenuButton button, String page) {
        try {
            AnchorPane mainPage = (AnchorPane) FXMLLoader.load(getClass().getResource(page + ".fxml"));

            Stage window = (Stage) button.getScene().getWindow();
            window.setScene(new Scene(mainPage));
            window.show();
        } catch (IOException e) {
            System.out.println("Io exception!");
        }
    }
}
