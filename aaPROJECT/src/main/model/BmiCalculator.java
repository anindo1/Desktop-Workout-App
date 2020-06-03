package model;
// This class is to represent BMI of the user to 2 decimal places

import exceptions.NotPositiveException;

import java.io.*;

public class BmiCalculator implements Serializable {

    private double bmiRounded;

    // EFFECTS: constructor for Bmi Calculator
    public BmiCalculator() {
        bmiRounded = 0.00;
    }

    // MODIFIES: this
    // EFFECTS: Checks if lbs, feet, inches are positive. If so returns the new rounded BMI given user's lbs, feet,
    //          inches. If not, then throw the NotPositiveException
    public double bmiImperial(double lbs, double feet, double inches) throws NotPositiveException {
        if (lbs <= 0.00 | feet <= 0.00 | inches <= 0.00) {
            throw new NotPositiveException();
        }
        double totalInches = feet * 12 + inches;
        double bmi = 703 * lbs / Math.pow(totalInches, 2);
        bmiRounded = Math.round(bmi * 100.0) / 100.0;
        return bmiRounded;
    }

    // MODIFIES: this
    // EFFECTS: Checks if kg and cm are positive, if so returns the new rounded BMI given user's kg, cm
    //          If not, then throw the NotPositiveException
    public double bmiMetric(double kg, double cm) throws NotPositiveException {
        if (kg <= 0.00 | cm <= 0.00) {
            throw new NotPositiveException();
        }
        double meters = cm / 100.0;
        double bmi = kg / Math.pow(meters, 2);
        bmiRounded = Math.round(bmi * 100.0) / 100.0;
        return bmiRounded;
    }

    public double getBmi() {
        return bmiRounded;
    }

    public void setBmiRounded(double bmiRounded) {
        this.bmiRounded = bmiRounded;
    }

}
