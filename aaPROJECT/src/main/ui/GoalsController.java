package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Goal;

import java.time.format.DateTimeFormatter;

// This class is the controller for the GoalsPage
public class GoalsController extends BasicControlsGoals {
    @FXML
    private Button mainMenu;

    @FXML
    private Button pendingButton;

    @FXML
    private Button accomplishedButton;

    @FXML
    private Button addGoalButton;

    @FXML
    private TextField userPriority;

    @FXML
    private TextField userGoal;

    @FXML
    private Text userDate;

    @FXML
    private Text generalError;

    @FXML
    private DatePicker datePicker;


    // Effects: initializes the images and sets some fields visibility to false
    @FXML
    public void initialize() {
        setInitialImages();
        userDate.setVisible(false);
        userGoal.setVisible(false);
        userPriority.setVisible(false);
        datePicker.setVisible(false);
        generalError.setVisible(false);
        addGoalButton.setVisible(false);
    }

    // Effects: Goes back to the MainPage
    @FXML
    public void back() {
        goTo(mainMenu, "MainPage");
    }

    // Effects: sets visibility of the fields associated with add goals to true
    @FXML
    public void addNewGoals() {
        userDate.setVisible(true);
        userGoal.setVisible(true);
        userPriority.setVisible(true);
        datePicker.setVisible(true);
        addGoalButton.setVisible(true);
    }

    // Effects: Goes to PendingGoalsPage
    @FXML
    public void goToPending() {
        goTo(pendingButton, "PendingGoalsPage");
    }

    // Effects: Goes to AccomplishedGoalsPage
    @FXML
    public void goToAccomplished() {
        goTo(accomplishedButton, "AccomplishedGoalsPage");
    }

    // Modifies: ListOfGoals
    // Effects: adds a goal to the pending list of goals
    public void addGoal() {
        try {
            int priority = Integer.parseInt(userPriority.getText());
            String goal = userGoal.getText();
            String date = datePicker.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Goal userGoal = new Goal(goal, date, priority, false);
            App.get().getListOfGoals().addGoal(userGoal);
        } catch (Exception e) {
            generalError.setVisible(true);
        }
        clear();
    }

    // Effects: Clears the textFields associated with add goal and sets the visibility of these to false
    public void clear() {
        userGoal.clear();
        userPriority.clear();
        datePicker.getEditor().clear();
        userGoal.setVisible(false);
        userPriority.setVisible(false);
        userDate.setVisible(false);
        datePicker.setVisible(false);
        generalError.setVisible(false);
        addGoalButton.setVisible(false);
    }
}
