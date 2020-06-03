package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// represents a list of goals with their priority
public class ListOfGoals implements Serializable {
    private List<Goal> pendingGoalList;
    private List<Goal> accomplishedGoalList;

    // MODIFIES: this
    // EFFECTS: constructs an empty list of pending goals and accomplished goals
    public ListOfGoals() {
        pendingGoalList = new ArrayList<Goal>();
        accomplishedGoalList = new ArrayList<Goal>();
    }

    // MODIFIES: this
    // EFFECTS: Adds a goal to the list of goals in ascending order of the priority of the goal.
    //          If the priority is already taken, then add 1 to everything of the same priority and below so the
    //          new priority takes its spot, and everything else is moved down 1 in the list.
    public void addGoal(Goal goal) {
        for (Goal g : pendingGoalList) {
            if (g.getPriority() == (goal.getPriority())) {
                for (Goal g2 : pendingGoalList) {
                    if (goal.getPriority() <= g2.getPriority()) {
                        g2.setPriority(g2.getPriority() + 1);
                    }
                }
            }
        }
        pendingGoalList.add(goal);
        Collections.sort(pendingGoalList, Comparator.comparingInt(Goal::getPriority));
    }

    // MODIFIES: this
    // EFFECTS: removes the goal with the given priority, if no goal with the priority, do nothing.
    public void deleteAccomplishedGoal(int priority) {
        for (Goal g : accomplishedGoalList) {
            if (g.getPriority() == priority) {
                accomplishedGoalList.remove(g);
                return;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: removes the goal with the given priority, if no goal with the priority, do nothing.
    public void deletePendingGoal(int priority) {
        for (Goal g : pendingGoalList) {
            if (g.getPriority() == priority) {
                pendingGoalList.remove(g);
                return;
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: accomplish a goal in a list of pending goals
    public void accomplishGoal(int priority) {
        for (Goal g : pendingGoalList) {
            if (g.getPriority() == priority) {
                g.accomplishGoal();
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds all accomplished goals from pending goal list to an accomplishedGoalList.
    //          If no accomplished goals, do nothing.
    public void accomplishGoalList() {
        for (Goal g : pendingGoalList) {
            if (g.isAccomplished()) {
                accomplishedGoalList.add(g);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: removes all accomplished goals from pending goal list
    public void removeAccomplishedGoals() {
        pendingGoalList.removeIf(Goal::isAccomplished);
    }

    public List<Goal> getAccomplishedGoalList() {
        return accomplishedGoalList;
    }

    public List<Goal> getPendingGoalList() {
        return pendingGoalList;
    }

    // EFFECTS: returns the number of goals in the pendingGoalList
    public int numberOfPendingGoals() {
        return pendingGoalList.size();
    }

    // EFFECTS: returns the number of goals in the accomplishedGoalList
    public int numberOfAccomplishedGoals() {
        return accomplishedGoalList.size();
    }

    // EFFECTS: returns every goal on a new line in a goalToString() format from a pending goal list
    public String pendingGoalsToString() {
        String pendingGoals = "";
        for (Goal g : pendingGoalList) {
            pendingGoals = pendingGoals.concat(g.goalToString()).concat("\n");
        }
        return pendingGoals;
    }

    // EFFECTS: returns every goal on a new line in a goalToString() format from an accomplished goal list
    public String accomplishedGoalsToString() {
        String accomplishedGoals = "";
        for (Goal g : accomplishedGoalList) {
            accomplishedGoals = accomplishedGoals.concat(g.goalToString()).concat("\n");
        }
        return accomplishedGoals;
    }
}
