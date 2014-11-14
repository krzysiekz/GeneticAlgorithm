package com.krzysiekz.genetic.fitness;

import com.krzysiekz.genetic.GenesToValueCalculator;
import com.krzysiekz.genetic.Individual;

/**
 * The interface that represents fitness function.
 */
public interface FitnessFunction {
    /**
     * Calculates fitness.
     *
     * @param individual the individual
     * @param converter the genes to value converter
     * @return the fitness
     */
    Double calculate(Individual individual, GenesToValueCalculator converter);
}
