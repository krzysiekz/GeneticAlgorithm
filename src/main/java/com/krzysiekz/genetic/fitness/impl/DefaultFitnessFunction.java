package com.krzysiekz.genetic.fitness.impl;

import com.krzysiekz.genetic.GenesToValueInRangeCalculator;
import com.krzysiekz.genetic.Individual;
import com.krzysiekz.genetic.fitness.FitnessFunction;

public class DefaultFitnessFunction implements FitnessFunction {

    @Override
    public Double calculate(Individual individual, GenesToValueInRangeCalculator converter) {
        double genesValue = converter.convert(individual);
        return calculateFitnessFunctionValue(genesValue);
     }

    private Double calculateFitnessFunctionValue(double genesValue) {
        return (Math.exp(genesValue) * Math.sin(10 * Math.PI * genesValue) + 1) / genesValue;
    }
}
