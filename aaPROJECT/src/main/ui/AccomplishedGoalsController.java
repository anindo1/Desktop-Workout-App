package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import model.Goal;

// This class is the controlled for the AccomplishedGoalsPage

public class AccomplishedGoalsController extends BasicControlsGoals {

    private ObservableList<String> accomplishedGoals = FXCollections.observableArrayList();

    @FXML
    private Button backButton;

    @FXML
    private Button mainMenu;

    @FXML
    private ListView<String> listView;

    // Effects: Sets up the images and and list items
    @FXML
    public void initialize() {
        setInitialImages();
        listView.setItems(accomplishedGoalsToList());
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    // Effects: Go back to the MainPage
    @FXML
    public void goToMainMenu() {
        goTo(mainMenu, "MainPage");
    }

    // Effects: Go back to the GoalsPage
    @FXML
    public void goBack() {
        goTo(backButton, "GoalsPage");
    }

    // Effects: displays the accomplished goals from accomplished goal list
    public ObservableList<String> accomplishedGoalsToList() {
        for (Goal g : App.get().getListOfGoals().getAccomplishedGoalList()) {
            accomplishedGoals.add(g.goalToString());
        }
        return accomplishedGoals;
    }

    // Effects: deletes goal from the list view
    public void deleteGoal() {
        ObservableList<String> selected;
        selected = listView.getSelectionModel().getSelectedItems();
        for (String s : selected) {
            deleteGoalInListOfGoals(s);
            listView.getItems().remove(s);
        }
    }

    // Modifies: ListOfGoals
    // Effects: deletes goal from accomplished goal list
    public void deleteGoalInListOfGoals(String s) {
        String[] splitStrings = s.split(" ", 2);
        String priorityString = splitStrings[0];
        int priority = Integer.parseInt(priorityString);
        App.get().getListOfGoals().deleteAccomplishedGoal(priority);
    }
}
