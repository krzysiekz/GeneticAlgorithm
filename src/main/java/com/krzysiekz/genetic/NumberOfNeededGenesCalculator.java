package com.krzysiekz.genetic;

/**
 * Class calculates number of needed genes.
 */
public class NumberOfNeededGenesCalculator {
    /**
     * Calculates number of needed genes.
     *
     * @param neededPrecision the needed precision
     * @param minimumRange the minimum range
     * @param maximumRange the maximum range
     * @return the number of needed genes
     */
    public int calculate(int neededPrecision, double minimumRange, double maximumRange) {
        int numberOfIntervals = (int) ((maximumRange - minimumRange) * Math.pow(10, neededPrecision));
        return findNumberOfNeededGenes(numberOfIntervals);
    }

    private int findNumberOfNeededGenes(int numberOfIntervals) {
        int numberOfNeededGenes = 0;
        do {
            numberOfNeededGenes++;
        } while ((Math.pow(2, numberOfNeededGenes)-1) < numberOfIntervals);
        return numberOfNeededGenes;
    }
}
