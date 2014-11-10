package com.krzysiekz.genetic;

public class NumberOfNeededGenesCalculator {
    public int calculate(int neededPrecision, double minimumRange, double maximumRange) {
        int numberOfIntervals = (int) ((maximumRange - minimumRange) * Math.pow(10, neededPrecision));
        return findNumberOfNeededGenes(numberOfIntervals);
    }

    private int findNumberOfNeededGenes(int numberOfIntervals) {
        int numberOfNeededGenes = 0;
        do {
            numberOfNeededGenes++;
        }while ((Math.pow(2, numberOfNeededGenes)-1) < numberOfIntervals);
        return numberOfNeededGenes;
    }
}
