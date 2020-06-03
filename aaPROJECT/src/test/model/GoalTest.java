package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GoalTest {
    private Goal testGoal1;
    private Goal testGoal2;

    @BeforeEach
    public void setup() {
        testGoal1 = new Goal("Bench 225", "june 2020", 1, false);
        testGoal2 = new Goal("Bench 135", "dec 2019", 1, true);
    }

    @Test
    public void testConstructor() {
        assertEquals("Bench 225", testGoal1.getTask());
        assertEquals("june 2020", testGoal1.getDate());
        assertEquals(1, testGoal1.getPriority());
        assertFalse(testGoal1.isAccomplished());
    }

    @Test
    public void testAccomplishGoal() {
        testGoal1.accomplishGoal();
        assertTrue(testGoal1.isAccomplished());
        testGoal2.accomplishGoal();
        assertTrue(testGoal2.isAccomplished());
    }

    @Test
    public void testGoalToString() {
        assertEquals("1 - Bench 225 - june 2020", testGoal1.goalToString());
    }
}
