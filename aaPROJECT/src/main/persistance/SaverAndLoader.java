package persistance;

import java.io.*;

import model.BmiCalculator;
import model.ListOfGoals;

// represents methods for saving and loading the bmi calculator and list of goals
public class SaverAndLoader {
    public String bmiFileName;
    public String listOfGoalsFileName;
    private BmiCalculator bmi;
    private ListOfGoals log;

    // EFFECTS: constructor to create a new SaverAndLoader with a new ListOfGoals and new BmiCalculator
    public SaverAndLoader() {
        log = new ListOfGoals();
        bmi = new BmiCalculator();
    }

    // REQUIRES: bmiName and listOfGoalsName to have a text file kind of name like: "./data/Bmi.txt"
    // MODIFIES: this
    // EFFECTS: writes a bmi calculator and list of goals objects into a text file
    public void save(BmiCalculator bmiCalculator, ListOfGoals listOfGoals,
                     String bmiName, String listOfGoalsName) throws IOException {
        this.bmiFileName = bmiName;
        this.listOfGoalsFileName = listOfGoalsName;

        // This part is for creating the user and password

        // This part is for saving the bmi calculator
        ObjectOutputStream osBmi = new ObjectOutputStream(new FileOutputStream(bmiFileName));
        osBmi.writeObject(bmiCalculator);
        osBmi.close();

        // This part is for saving the list of goals
        ObjectOutputStream osLog = new ObjectOutputStream(new FileOutputStream(listOfGoalsFileName));
        osLog.writeObject(listOfGoals);
        osLog.close();
    }

    // REQUIRES: bmiName and listOfGoalsName to be real text file names saved in the project
    // MODIFIES: this
    // EFFECTS: causes the current bmi calculator and list of goals object to be the last saved bmi calculator
    //          and list of goals object. Prints "there are no saved accounts here" if the requires clause is
    //          not followed.
    public void load(String bmiName, String listOfGoalsName) throws IOException, ClassNotFoundException {
        this.bmiFileName = bmiName;
        this.listOfGoalsFileName = listOfGoalsName;
        // This part is for loading the last bmi calculator
        ObjectInputStream isBmi = new ObjectInputStream(new FileInputStream(bmiFileName));
        this.bmi = (BmiCalculator) isBmi.readObject();
        isBmi.close();

        // This part is for loading the last list of goals
        ObjectInputStream isLog = new ObjectInputStream(new FileInputStream(listOfGoalsFileName));
        this.log = (ListOfGoals) isLog.readObject();
        isLog.close();
    }

    public BmiCalculator getBmiCalculator() {
        return bmi;
    }

    public ListOfGoals getListOfGoals() {
        return log;
    }
}
