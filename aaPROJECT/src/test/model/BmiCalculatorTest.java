package model;

import exceptions.NotPositiveException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BmiCalculatorTest {
    private BmiCalculator testBmiCalculator;

    @BeforeEach
    public void setup() {
        testBmiCalculator = new BmiCalculator();
    }

    @Test
    public void testBmiImperialNoException() {
        try {
            testBmiCalculator.bmiImperial(173.42, 6, 1.43);
            assertEquals(22.61, testBmiCalculator.getBmi());
        } catch (NotPositiveException e) {
            fail("no exception should be thrown");
        }
    }

    @Test
    public void testBmiImperialExceptionLbs() {
        try {
            testBmiCalculator.bmiImperial(-173.42, 5, 1.43);
            fail("exception should be thrown");
        } catch (NotPositiveException e) {
            // expected
        }
    }

    @Test
    public void testBmiImperialExceptionFeet() {
        try {
            testBmiCalculator.bmiImperial(173.42, -5, 1.43);
            fail("exception should be thrown");
        } catch (NotPositiveException e) {
            // expected
        }
    }

    @Test
    public void testBmiImperialExceptionInches() {
        try {
            testBmiCalculator.bmiImperial(173.42, 5, -1.43);
            fail("exception should be thrown");
        } catch (NotPositiveException e) {
            // expected
        }
    }

    @Test
    public void testBmiImperialExceptionAll3() {
        try {
            testBmiCalculator.bmiImperial(-173.42, -5, -1.43);
            fail("exception should be thrown");
        } catch (NotPositiveException e) {
            // expected
        }
    }

    @Test
    public void testBmiMetricNoException() {
        try {
            testBmiCalculator.bmiMetric(54.32, 198.21);
            assertEquals(13.83, testBmiCalculator.getBmi());
        } catch (NotPositiveException e) {
            fail("no exception should be thrown");
        }
    }

    @Test
    public void testBmiMetricExceptionKg() {
        try {
            testBmiCalculator.bmiMetric(-54.32, 198.21);
            assertEquals(13.83, testBmiCalculator.getBmi());
            fail("exceoption should be thrown");
        } catch (NotPositiveException e) {
            // expected
        }
    }

    @Test
    public void testBmiMetricExceptionCm() {
        try {
            testBmiCalculator.bmiMetric(54.32, -198.21);
            assertEquals(13.83, testBmiCalculator.getBmi());
            fail("exceoption should be thrown");
        } catch (NotPositiveException e) {
            // expected
        }
    }

    @Test
    public void testBmiMetricExceptionAll2() {
        try {
            testBmiCalculator.bmiMetric(-54.32, -198.21);
            assertEquals(13.83, testBmiCalculator.getBmi());
            fail("exceoption should be thrown");
        } catch (NotPositiveException e) {
            // expected
        }
    }

}