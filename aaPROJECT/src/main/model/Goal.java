package model;

import java.io.Serializable;

// represents a single personal goal with the task, date, priority, and if it is accomplished
public class Goal implements Serializable {
    private String task;
    private String date;
    private int priority;
    private boolean isAccomplished = false;

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // EFFECTS: constructs a new goal with a task and date
    public Goal(String task, String date, int priority, boolean isAccomplished) {
        this.task = task;
        this.date = date;
        this.priority = priority;
        this.isAccomplished = isAccomplished;
    }

    public String getTask() {
        return task;
    }

    public String getDate() {
        return date;
    }

    public int getPriority() {
        return priority;
    }

    // EFFECTS: returns true if goal is accomplished, false otherwise
    public boolean isAccomplished() {
        return isAccomplished;
    }

    // MODIFIES: this
    // EFFECTS: accomplishes the goal
    public void accomplishGoal() {
        isAccomplished = true;
    }

    // EFFECTS: returns a goal in the format of: priority - task - date
    public String goalToString() {
        return priority + " - " + task + " - " + date;
    }

}
