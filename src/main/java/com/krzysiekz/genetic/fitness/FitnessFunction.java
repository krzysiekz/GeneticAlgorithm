package com.krzysiekz.genetic.fitness;

import com.krzysiekz.genetic.GenesToValueCalculator;
import com.krzysiekz.genetic.Individual;

public interface FitnessFunction {
    Double calculate(Individual individual, GenesToValueCalculator converter);
}
