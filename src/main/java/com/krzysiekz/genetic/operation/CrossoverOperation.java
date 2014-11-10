package com.krzysiekz.genetic.operation;

import com.krzysiekz.genetic.Individual;

public class CrossoverOperation {

    private int crossoverPoint = 0;

    public CrossoverOperation(int crossoverPoint) {
        this.crossoverPoint = crossoverPoint;
    }

    public void apply(Individual individualA, Individual individualB) {
        setCrossoverPointIfNeeded(individualA);
        for (int i = crossoverPoint; i < individualA.getGenes().length; i++) {
            byte temporary = individualA.getGene(i);
            individualA.setGene(i, individualB.getGene(i));
            individualB.setGene(i, temporary);
        }
    }

    private void setCrossoverPointIfNeeded(Individual individualA) {
        if(crossoverPoint == 0){
            crossoverPoint = (int) (Math.random() * individualA.getGenes().length);
        }
    }
}
