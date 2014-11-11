package com.krzysiekz.genetic;

import com.krzysiekz.genetic.operation.CrossoverOperation;
import com.krzysiekz.genetic.operation.MutationOperation;

public class GeneticAlgorithmOperations {
    private CrossoverOperation crossoverOperation;
    private MutationOperation mutationOperation;

    public GeneticAlgorithmOperations(CrossoverOperation crossoverOperation, MutationOperation mutationOperation) {
        this.crossoverOperation = crossoverOperation;
        this.mutationOperation = mutationOperation;
    }

    public CrossoverOperation getCrossoverOperation() {
        return crossoverOperation;
    }

    public MutationOperation getMutationOperation() {
        return mutationOperation;
    }
}
