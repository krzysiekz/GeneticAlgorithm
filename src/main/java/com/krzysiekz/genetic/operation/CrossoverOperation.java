package com.krzysiekz.genetic.operation;

import com.krzysiekz.genetic.Individual;

import java.util.Random;

/**
 * The class that represents Crossover operation.
 */
public class CrossoverOperation {

    private Random random;

    public CrossoverOperation(long seed) {
        random = new Random(seed);
    }

    public CrossoverOperation() {
        random = new Random();
    }

    /**
     * Applies crossover operation on given individuals.
     *
     * @param individualA the individual a
     * @param individualB the individual b
     */
    public void apply(Individual individualA, Individual individualB) {
        int crossoverPoint = random.nextInt(individualA.getGenes().length);
        for (int i = crossoverPoint; i < individualA.getGenes().length; i++) {
            byte temporary = individualA.getGene(i);
            individualA.setGene(i, individualB.getGene(i));
            individualB.setGene(i, temporary);
        }
    }
}
