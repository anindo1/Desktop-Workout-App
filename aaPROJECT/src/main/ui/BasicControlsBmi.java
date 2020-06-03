package ui;

// An abstract class for basic methods used by the FXML Controllers: BmiController, ImperialBmiController,
// MetricBmiController

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public abstract class BasicControlsBmi extends BasicControlsUniversal {
    @FXML
    protected ImageView bmiImage;

    @FXML
    protected ImageView bgImage;

    @FXML
    protected ImageView titleImage;

    @FXML
    protected ImageView titleLogo;


    // Effects: returns a status of the user based on his bmi
    public String status(Double bmi) {
        if (bmi >= 35) {
            return "Extremely Obese";
        } else if (bmi >= 30) {
            return "Obese";
        } else if (bmi >= 25) {
            return "Overweight";
        } else if (bmi >= 18.5) {
            return "Normal";
        } else {
            return "Underweight";
        }
    }

    public void setInitialImages() {
        Image titleImg = new Image("file:data/Title.jpg");
        titleImage.setImage(titleImg);
        Image title = new Image("file:data/LogoPNG.png");
        titleLogo.setImage(title);
        Image bmiImg = new Image("file:data/bmiImage.jpg");
        bmiImage.setImage(bmiImg);
        Image bgImg = new Image("file:data/tiger background.jpg");
        bgImage.setImage(bgImg);
    }

}
