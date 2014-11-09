package com.krzysiekz.genetic.fitness;

import com.krzysiekz.genetic.GenesToValueInRangeCalculator;
import com.krzysiekz.genetic.Individual;

public interface FitnessFunction {
    Double calculate(Individual individual, GenesToValueInRangeCalculator converter);
}
