package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Goal;

// This class is the controller for PendingGoalsPage
public class PendingGoalsController extends BasicControlsGoals {
    private ObservableList<String> pendingGoals = FXCollections.observableArrayList();

    @FXML
    private Button backButton;

    @FXML
    private Button mainMenu;

    @FXML
    private ListView<String> listView;


    // Effects: initializes the initial images and displays the pending goals from list of goals onto the list view
    @FXML
    public void initialize() {
        setInitialImages();
        listView.setItems(pendingGoalsToList());
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    // Effects: Goes to MainPage
    @FXML
    public void goToMainMenu() {
        goTo(mainMenu, "MainPage");
    }

    // Effects: Goes back to GoalsPage
    @FXML
    public void goBack() {
        goTo(backButton, "GoalsPage");
    }

    // Effects: displays the accomplished goals from accomplished goal list
    @FXML
    public ObservableList<String> pendingGoalsToList() {
        for (Goal g : App.get().getListOfGoals().getPendingGoalList()) {
            pendingGoals.add(g.goalToString());
        }
        return pendingGoals;
    }

    // Modifies: ListOfGoals
    // Effects: deletes the selected goal from the list view and list of pending goals
    @FXML public void deleteGoal() {
        ObservableList<String> selected;
        selected = listView.getSelectionModel().getSelectedItems();
        for (String s : selected) {
            deleteGoalInListOfGoals(s);
            listView.getItems().remove(s);
        }
    }

    // Modifies: ListOfGoals
    // Effects: Adds the selected goal to the accomplished goals list and removes it from the pending goals list
    @FXML public void accomplishGoal() {
        ObservableList<String> selected;
        selected = listView.getSelectionModel().getSelectedItems();
        for (String s : selected) {
            accomplishGoalInListOfGoals(s);
            listView.getItems().remove(s);
        }
        App.get().getListOfGoals().accomplishGoalList();
        App.get().getListOfGoals().removeAccomplishedGoals();
    }

    // Helper for accomplishGoal()
    // Effects: Adds the selected goal to the accomplished goals list and removes it from the pending goals list
    public void accomplishGoalInListOfGoals(String s) {
        String[] splitStrings = s.split(" ", 2);
        String priorityString = splitStrings[0];
        int priority = Integer.parseInt(priorityString);
        App.get().getListOfGoals().accomplishGoal(priority);
    }

    // Helper for deleteGoal()
    // Effects: deletes the selected goal from the list view and list of pending goals
    public void deleteGoalInListOfGoals(String s) {
        String[] splitStrings = s.split(" ", 2);
        String priorityString = splitStrings[0];
        int priority = Integer.parseInt(priorityString);
        App.get().getListOfGoals().deletePendingGoal(priority);
    }
}
