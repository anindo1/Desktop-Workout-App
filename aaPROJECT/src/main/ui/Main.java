package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// This is the Main class to initially run the program
public class Main extends Application {

    // Effects: Runs the program
    public static void main(String[] args) {
        launch(args);
    }

    // Effects: Displays the first scene
    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setResizable(false);
        App.init(primaryStage);
    }
}
