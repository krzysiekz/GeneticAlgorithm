package com.krzysiekz.genetic;

import com.krzysiekz.genetic.fitness.FitnessFunction;

public class Individual {

    private static final int DEFAULT_NUMBER_OF_GENES = 64;
    private byte[] genes;
    private Double fitness;

    public Individual(int numberOfGenes) {
        genes = new byte[numberOfGenes];
    }

    public Individual() {
        genes = new byte[DEFAULT_NUMBER_OF_GENES];
    }

    public byte[] getGenes() {
        return genes;
    }

    public void initializeGenes() {
        for (int i = 0; i < genes.length; i++) {
            genes[i] = getRandomGenValue();
        }
    }

    byte getRandomGenValue() {
        return (byte) Math.round(Math.random());
    }

    public void calculateFitness(FitnessFunction fitnessFunction, GenesToValueInRangeCalculator calculator) {
        fitness = fitnessFunction.calculate(this, calculator);
    }

    public Double getFitness() {
        return fitness;
    }

    public void setGenes(byte[] genes) {
        this.genes = genes;
    }

    public void setGene(int index, byte geneValue) {
        genes[index] = geneValue;
    }

    public byte getGene(int index) {
        return genes[index];
    }
}
