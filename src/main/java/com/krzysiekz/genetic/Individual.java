package com.krzysiekz.genetic;

import com.krzysiekz.genetic.fitness.FitnessFunction;

import java.util.Arrays;

/**
 * The class represents Individual.
 */
public class Individual {

    private static final int DEFAULT_NUMBER_OF_GENES = 64;
    private byte[] genes;
    private Double fitness;

    /**
     * Instantiates a new Individual.
     *
     * @param numberOfGenes the number of genes
     */
    public Individual(int numberOfGenes) {
        genes = new byte[numberOfGenes];
    }

    /**
     * Instantiates a new Individual.
     */
    public Individual() {
        genes = new byte[DEFAULT_NUMBER_OF_GENES];
    }

    /**
     * Instantiates a new Individual.
     *
     * @param individual the individual
     */
    public Individual(Individual individual) {
        this.genes = Arrays.copyOf(individual.getGenes(), individual.getGenes().length);
        this.fitness = individual.getFitness();
    }

    /**
     * Get genes.
     *
     * @return the byte [ ]
     */
    public byte[] getGenes() {
        return genes;
    }

    /**
     * Initialize genes.
     */
    public void initializeGenes() {
        for (int i = 0; i < genes.length; i++) {
            genes[i] = getRandomGenValue();
        }
    }

    byte getRandomGenValue() {
        return (byte) Math.round(Math.random());
    }

    /**
     * Calculate fitness.
     *
     * @param fitnessFunction the fitness function
     * @param calculator the calculator
     */
    public void calculateFitness(FitnessFunction fitnessFunction, GenesToValueCalculator calculator) {
        fitness = fitnessFunction.calculate(this, calculator);
    }

    /**
     * Gets fitness.
     *
     * @return the fitness
     */
    public Double getFitness() {
        return fitness;
    }

    /**
     * Sets genes.
     *
     * @param genes the genes
     */
    public void setGenes(byte[] genes) {
        this.genes = genes;
    }

    /**
     * Sets gene.
     *
     * @param index the index
     * @param geneValue the gene value
     */
    public void setGene(int index, byte geneValue) {
        genes[index] = geneValue;
    }

    /**
     * Gets gene.
     *
     * @param index the index
     * @return the gene
     */
    public byte getGene(int index) {
        return genes[index];
    }
}
