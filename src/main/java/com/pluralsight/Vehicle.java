package com.pluralsight;

import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    // constructor

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }
    public  double getValue(){
        LocalDate now = LocalDate.now();
        int currentYear = now.getYear();
        int age =currentYear-this.year;

        double value;

        if (age <= 3) {
            // reduce original cost by 3% per year
            value = getOriginalCost() - (getOriginalCost() * 0.03 * age);
        } else if (age <= 6) {
            // reduce original cost by 6% per year
            value = getOriginalCost() - (getOriginalCost() * 0.06 * age);
        } else if (age <= 10) {
            // reduce original cost by 8% per year
            value = getOriginalCost() - (getOriginalCost() * 0.08 * age);
        } else {
            // over 10 years old
            value = 1000;
        }
        // if it is over 100,000 mile reduce value buy 25 %
        if (value < 0) {
            value = 0;
        }

        // Minus reduce final value by 25% if over 100,000 miles
        // unless makeModel contains word Honda or Toyota
        if (odometer > 100000) {
            boolean isReliable = makeModel != null &&
                    (makeModel.toLowerCase().contains("honda") ||
                            makeModel.toLowerCase().contains("toyota"));
            if (!isReliable) {
                value = value - (value * 0.25);
            }
        }
        return value;
    }
}
