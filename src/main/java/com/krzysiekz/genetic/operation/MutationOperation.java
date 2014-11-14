package com.krzysiekz.genetic.operation;

import com.krzysiekz.genetic.Individual;

import java.util.Random;

/**
 * The class that represents mutation operation.
 */
public class MutationOperation {

    private Random random;

    public MutationOperation(long seed) {
        random = new Random(seed);
    }

    public MutationOperation() {
        random = new Random();
    }

    /**
     * Applies mutation operation on given individual.
     *
     * @param individual the individual
     * @param probabilityOfMutation the probability of mutation
     */
    public void apply(Individual individual, double probabilityOfMutation) {
        byte[] genes = individual.getGenes();
        for (int i = 0; i < genes.length; i++) {
            if(random.nextDouble() < probabilityOfMutation) {
                byte newValue = getNewGeneValue(individual.getGene(i));
                individual.setGene(i, newValue);
            }
        }
    }

    private byte getNewGeneValue(byte oldGeneValue) {
        if(oldGeneValue == 0) {
            return 1;
        }else {
            return 0;
        }
    }
}
