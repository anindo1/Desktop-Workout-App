package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ListOfGoalsTest {
    private Goal testPrio1;
    private Goal testPrio3;
    private Goal testPrio4;
    private Goal testNewPrio3;
    private ListOfGoals testListOfGoals;
    private ListOfGoals testListOfEmptyGoals;

    @BeforeEach
    public void setup() {
        testPrio1 = new Goal("Prio 1 Goal", "never", 1, false);
        testPrio3 = new Goal("Prio 3 Goal", "never", 3, false);
        testPrio4 = new Goal("Prio 4 Goal", "never", 4, false);
        testNewPrio3 = new Goal("New Prio 3 Goal", "never", 3, false);
        testListOfGoals = new ListOfGoals();
        testListOfGoals.addGoal(testPrio1);
        testListOfGoals.addGoal(testPrio3);
        testListOfEmptyGoals = new ListOfGoals();
    }

    @Test
    public void testConstructor() {
        assertEquals(0, testListOfEmptyGoals.numberOfPendingGoals());
        assertEquals(0, testListOfEmptyGoals.numberOfAccomplishedGoals());
    }

    @Test
    public void testAddGoalNoGoals() {
        testListOfEmptyGoals.addGoal(testPrio1);
        assertEquals(1, testListOfEmptyGoals.numberOfPendingGoals());
        assertEquals(0, testListOfEmptyGoals.numberOfAccomplishedGoals());
        assertTrue(testListOfEmptyGoals.getPendingGoalList().contains(testPrio1));
    }

    // Tests what happens when you add a goal to a list with a goal that has a different priority
    @Test
    public void testAddGoalWithGoalOfNewPriority() {
        assertEquals(2, testListOfGoals.numberOfPendingGoals());
        assertEquals(0, testListOfEmptyGoals.numberOfAccomplishedGoals());
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio1));
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio3));
        assertEquals(1, testPrio1.getPriority());
        assertEquals(3, testPrio3.getPriority());
    }


    // Tests what happens when you add a goal to a list with a goal that has the same priority
    @Test
    public void testAddGoalWithGoalOfSamePriority() {
        testListOfGoals.addGoal(testPrio4);
        testListOfGoals.addGoal(testNewPrio3);
        assertEquals(4, testListOfGoals.numberOfPendingGoals());
        assertEquals(0, testListOfGoals.numberOfAccomplishedGoals());
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio1));
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio3));
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio4));
        assertTrue(testListOfGoals.getPendingGoalList().contains(testNewPrio3));
        assertEquals(1, testPrio1.getPriority());
        assertEquals(4, testPrio3.getPriority());
        assertEquals(5, testPrio4.getPriority());
        assertEquals(3, testNewPrio3.getPriority());
    }

    @Test
    public void testAddGoalWithSamePriority1() {
        testListOfGoals.addGoal(testPrio4);
        testListOfGoals.addGoal(testNewPrio3);
        Goal newPrio1 = new Goal("New Prio 1", "please pass coverage", 1, false);
        testListOfGoals.addGoal(newPrio1);
        assertEquals(5, testListOfGoals.numberOfPendingGoals());
        assertEquals(0, testListOfGoals.numberOfAccomplishedGoals());
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio1));
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio3));
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio4));
        assertTrue(testListOfGoals.getPendingGoalList().contains(testNewPrio3));
        assertTrue(testListOfGoals.getPendingGoalList().contains(newPrio1));
        assertEquals(2, testPrio1.getPriority());
        assertEquals(5, testPrio3.getPriority());
        assertEquals(6, testPrio4.getPriority());
        assertEquals(4, testNewPrio3.getPriority());
        assertEquals(1, newPrio1.getPriority());
    }

    @Test
    public void testDeletePendingGoalNonEmptyList() {
        testListOfGoals.deletePendingGoal(1);
        assertEquals(1, testListOfGoals.numberOfPendingGoals());
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio3));
        assertFalse(testListOfGoals.getPendingGoalList().contains(testPrio1));
        assertEquals(0, testListOfGoals.numberOfAccomplishedGoals());
    }

    @Test
    public void testDeletePendingGoalEmptyList() {
        testListOfEmptyGoals.deletePendingGoal(1);
        assertEquals(0, testListOfEmptyGoals.numberOfPendingGoals());
    }

    @Test
    public void testDeletePendingGoalInvalidPriority() {
        testListOfGoals.deletePendingGoal(13);
        assertEquals(2, testListOfGoals.numberOfPendingGoals());
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio3));
        assertTrue(testListOfGoals.getPendingGoalList().contains(testPrio1));
        assertEquals(0, testListOfGoals.numberOfAccomplishedGoals());
    }

    @Test
    public void testDeleteAccomplishedGoalNonEmptyList() {
        testListOfGoals.accomplishGoal(1);
        testListOfGoals.accomplishGoalList();
        testListOfGoals.removeAccomplishedGoals();
        testListOfGoals.deleteAccomplishedGoal(1);
        assertEquals(0, testListOfGoals.getAccomplishedGoalList().size());
    }

    @Test
    public void testDeleteAccomplishedGoalInvalidPriority() {
        testListOfGoals.accomplishGoal(1);
        testListOfGoals.accomplishGoalList();
        testListOfGoals.removeAccomplishedGoals();
        testListOfGoals.deleteAccomplishedGoal(13);
        assertEquals(1, testListOfGoals.getAccomplishedGoalList().size());
    }

    @Test
    public void testAccomplishGoal() {
        testListOfGoals.accomplishGoal(1);
        testListOfGoals.accomplishGoal(3);
        assertTrue(testPrio3.isAccomplished());
        assertTrue(testPrio1.isAccomplished());
    }

    @Test
    public void testAccomplishGoalList() {
        testListOfGoals.accomplishGoal(1);
        testListOfGoals.accomplishGoal(3);
        testListOfGoals.accomplishGoalList();
        assertTrue(testListOfGoals.getAccomplishedGoalList().contains(testPrio3));
        assertTrue(testListOfGoals.getAccomplishedGoalList().contains(testPrio1));
        assertEquals(2, testListOfGoals.numberOfAccomplishedGoals());
    }

    @Test
    public void testAccomplishGoalListNoAccomplishedGoals() {
        testListOfGoals.accomplishGoalList();
        assertEquals(0, testListOfGoals.numberOfAccomplishedGoals());
        assertEquals(2, testListOfGoals.numberOfPendingGoals());
    }

    @Test
    public void testAccomplishedGoalsComplex() {
        testListOfGoals.addGoal(testPrio4);
        testListOfGoals.addGoal(testNewPrio3);
        testListOfGoals.accomplishGoal(1);
        testListOfGoals.accomplishGoal(3);
        testListOfGoals.accomplishGoal(4);
        testListOfGoals.accomplishGoal(5);
        testListOfGoals.accomplishGoalList();
        assertEquals(4, testListOfGoals.numberOfAccomplishedGoals());
    }

    @Test
    public void testRemoveAccomplishGoals() {
        testListOfGoals.accomplishGoal(1);
        testListOfGoals.accomplishGoal(3);
        testListOfGoals.accomplishGoalList();
        testListOfGoals.removeAccomplishedGoals();
        assertEquals(0, testListOfGoals.numberOfPendingGoals());
    }

    @Test
    public void testRemoveAccomplishedGoalsComplex() {
        testListOfGoals.addGoal(testPrio4);
        testListOfGoals.addGoal(testNewPrio3);
        testListOfGoals.accomplishGoal(1);
        testListOfGoals.accomplishGoal(3);
        testListOfGoals.accomplishGoal(4);
        testListOfGoals.accomplishGoal(5);
        testListOfGoals.removeAccomplishedGoals();
        assertEquals(0, testListOfGoals.numberOfPendingGoals());
    }

    @Test
    public void testNumberOfPendingGoals() {
        assertEquals(2, testListOfGoals.numberOfPendingGoals());
    }

    @Test
    public void testNumberOfAccomplishedGoals() {
        testListOfGoals.accomplishGoal(1);
        testListOfGoals.accomplishGoal(3);
        testListOfGoals.accomplishGoalList();
        assertEquals(2, testListOfGoals.numberOfAccomplishedGoals());
    }

    // added goals does not need to be re organized
    @Test
    public void testPendingGoalsToStringSimple() {
        assertEquals("1 - Prio 1 Goal - never\n3 - Prio 3 Goal - never\n",
                testListOfGoals.pendingGoalsToString());
    }

    // added goals need to be re organized
    @Test
    public void testPendingGoalsToStringComplex() {
        testListOfGoals.addGoal(testPrio4);
        testListOfGoals.addGoal(testNewPrio3);
        assertEquals("1 - Prio 1 Goal - never\n3 - New Prio 3 Goal - never\n4 - Prio 3 Goal - never\n" +
                        "5 - Prio 4 Goal - never\n",
                testListOfGoals.pendingGoalsToString());
    }

    @Test
    public void testAccomplishedGoalsToString() {
        testListOfGoals.addGoal(testPrio4);
        testListOfGoals.addGoal(testNewPrio3);
        testListOfGoals.accomplishGoal(1);
        testListOfGoals.accomplishGoal(3);
        testListOfGoals.accomplishGoal(4);
        testListOfGoals.accomplishGoal(5);
        testListOfGoals.accomplishGoalList();
        assertEquals("1 - Prio 1 Goal - never\n3 - New Prio 3 Goal - never\n4 - Prio 3 Goal - never\n" +
                        "5 - Prio 4 Goal - never\n",
                testListOfGoals.accomplishedGoalsToString());
    }
}
