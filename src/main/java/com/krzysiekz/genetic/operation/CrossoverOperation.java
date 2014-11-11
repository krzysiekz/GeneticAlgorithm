package com.krzysiekz.genetic.operation;

import com.krzysiekz.genetic.Individual;

import java.util.Random;

public class CrossoverOperation {

    private Random random;

    public CrossoverOperation(long seed) {
        random = new Random(seed);
    }

    public CrossoverOperation() {
        random = new Random();
    }

    public void apply(Individual individualA, Individual individualB) {
        int crossoverPoint = random.nextInt(individualA.getGenes().length);
        for (int i = crossoverPoint; i < individualA.getGenes().length; i++) {
            byte temporary = individualA.getGene(i);
            individualA.setGene(i, individualB.getGene(i));
            individualB.setGene(i, temporary);
        }
    }
}
