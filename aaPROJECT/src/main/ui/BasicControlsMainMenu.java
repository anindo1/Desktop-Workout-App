package ui;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// An abstract class for basic methods used by the FXML Controllers: MainMenuController and MainPageController
public abstract class BasicControlsMainMenu extends BasicControlsUniversal {
    @FXML
    protected ImageView mainMenuImage;

    @FXML
    protected ImageView titleImage;

    @FXML
    protected ImageView titleLogo;

    // Effects: Sets up the images used by all subclasses
    public void setInitialImages() {
        Image img = new Image("file:data/BackgroundImage.jpg");
        mainMenuImage.setImage(img);
        Image titleImg = new Image("file:data/Title.jpg");
        titleImage.setImage(titleImg);
        Image title = new Image("file:data/LogoPNG.png");
        titleLogo.setImage(title);
    }
}
