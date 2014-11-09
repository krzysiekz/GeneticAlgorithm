package com.krzysiekz.genetic;

import java.math.BigInteger;

public class GenesToValueInRangeCalculator {
    private final double minRange;
    private final double maxRange;

    public GenesToValueInRangeCalculator(double minRange, double maxRange) {
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public Double convert(Individual individual) {
        return calculateGenesValue(individual);
    }

    private double calculateGenesValue(Individual individual) {
        double genesValue;
        double decimalValue = calculateDecimalValueOfGenes(individual);
        genesValue = minRange + (((maxRange - minRange)  * decimalValue)
                / (Math.pow(2, individual.getGenes().length) - 1));
        return genesValue;
    }

    private double calculateDecimalValueOfGenes(Individual individual) {
        String returnValue = "";
        BigInteger calculatedValue = BigInteger.ZERO;
        BigInteger poweredBase = BigInteger.ONE;
        BigInteger inputSystemBig = new BigInteger(String.valueOf(2));
        BigInteger outputSystemBig = new BigInteger(String.valueOf(10));
        String numberToConvert = convertGenesToString(individual.getGenes());

        while (numberToConvert.length() > 0) {
            char digit = numberToConvert.charAt(numberToConvert.length() - 1);
            calculatedValue = calculatedValue.add(poweredBase.multiply(new BigInteger(String.valueOf(digit))));
            numberToConvert = numberToConvert.substring(0,numberToConvert.length() - 1);
            poweredBase = poweredBase.multiply(inputSystemBig);
        }

        while (calculatedValue.compareTo(outputSystemBig) != -1) {
            int digitVal = (calculatedValue.divideAndRemainder(outputSystemBig)[1]).intValue();
            returnValue = digitVal + returnValue;
            calculatedValue = calculatedValue.divide(outputSystemBig);
        }

        returnValue = calculatedValue.intValue() + returnValue;
        return Double.valueOf(returnValue);
    }

    private String convertGenesToString(byte[] genes) {
        StringBuilder genesString = new StringBuilder();
        for (byte gene : genes) {
            genesString.append(gene);
        }
        return genesString.toString();
    }
}
