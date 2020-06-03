package ui;

// An abstract class for basic methods used by the Goal related FXML Controllers: GoalsController,
// PendingGoalsController, AccomplishedGoalsController

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class BasicControlsGoals extends BasicControlsUniversal {
    @FXML
    protected ImageView background;

    @FXML
    protected ImageView anindoImg;

    @FXML
    public void setInitialImages() {
        Image anindo = new Image("file:data/anindo.jpg");
        anindoImg.setImage(anindo);
        Image img = new Image("file:data/GoalsBI.png");
        background.setImage(img);
    }

}
