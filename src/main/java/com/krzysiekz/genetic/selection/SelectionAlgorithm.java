package com.krzysiekz.genetic.selection;

import com.krzysiekz.genetic.Population;

/**
 * The interface that represents selection algorithm.
 */
public interface SelectionAlgorithm {
    /**
     * Creates new population.
     *
     * @param population the population
     * @return the population
     */
    Population createNewPopulation(Population population);
}
