package persistance;

import model.BmiCalculator;
import model.Goal;
import model.ListOfGoals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class SaverAndLoaderTest {
    String testBmiFileName = "./data/testBmi.txt";
    String testListOfGoalsFileName = "./data/testListOfGoals.txt";
    private BmiCalculator testBmi;
    private ListOfGoals testLog;
    private SaverAndLoader testSaverAndLoader;
    SaverAndLoader testEmptySaverAndLoader;

    @BeforeEach
    void setup() {
        testBmi = new BmiCalculator();
        testLog = new ListOfGoals();
        testSaverAndLoader = new SaverAndLoader();
        Goal testGoal = new Goal("Finish phase 2", "Tonight", 1, false);

        testBmi.setBmiRounded(22.50);
        testLog.addGoal(testGoal);
    }

    @Test
    public void testConstructor() {
        testEmptySaverAndLoader = new SaverAndLoader();
        assertEquals(0, testEmptySaverAndLoader.getListOfGoals().numberOfPendingGoals());
        assertEquals(0, testEmptySaverAndLoader.getListOfGoals().numberOfAccomplishedGoals());
        assertEquals(0.00, testEmptySaverAndLoader.getBmiCalculator().getBmi());
    }

    @Test
    public void testSaveAndLoad() {
        try {
            testSaverAndLoader.save(testBmi, testLog, testBmiFileName, testListOfGoalsFileName);
        } catch (IOException e) {
            e.printStackTrace();
            fail("no exception should be thrown");
        }
        try {
            testSaverAndLoader.load(testBmiFileName, testListOfGoalsFileName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            fail("no exception should be thrown");
        }
        assertEquals(22.50, testSaverAndLoader.getBmiCalculator().getBmi());
        assertEquals(1, testSaverAndLoader.getListOfGoals().numberOfPendingGoals());
    }


    @Test
    public void testIOExceptionForLoad() {
        try {
            testSaverAndLoader.load("fakefake.txt", "even more fake.txt");
            fail("exception should be thrown");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("test worked");
            // this is expected
        }
    }
}
