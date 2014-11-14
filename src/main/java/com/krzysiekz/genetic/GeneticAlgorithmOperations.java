package com.krzysiekz.genetic;

import com.krzysiekz.genetic.operation.CrossoverOperation;
import com.krzysiekz.genetic.operation.MutationOperation;

/**
 * The class holds Genetic algorithm operations.
 */
public class GeneticAlgorithmOperations {
    private CrossoverOperation crossoverOperation;
    private MutationOperation mutationOperation;

    /**
     * Instantiates a new Genetic algorithm operations.
     *
     * @param crossoverOperation the crossover operation
     * @param mutationOperation the mutation operation
     */
    public GeneticAlgorithmOperations(CrossoverOperation crossoverOperation, MutationOperation mutationOperation) {
        this.crossoverOperation = crossoverOperation;
        this.mutationOperation = mutationOperation;
    }

    /**
     * Gets crossover operation.
     *
     * @return the crossover operation
     */
    public CrossoverOperation getCrossoverOperation() {
        return crossoverOperation;
    }

    /**
     * Gets mutation operation.
     *
     * @return the mutation operation
     */
    public MutationOperation getMutationOperation() {
        return mutationOperation;
    }
}
