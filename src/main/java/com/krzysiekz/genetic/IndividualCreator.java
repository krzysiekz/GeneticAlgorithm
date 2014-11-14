package com.krzysiekz.genetic;

/**
 * The class creates Individuals.
 */
public class IndividualCreator {

    /**
     * Create individual.
     *
     * @return the individual
     */
    public Individual create() {
        return new Individual();
    }

    /**
     * Create individual.
     *
     * @param numberOfGenes the number of genes
     * @return the individual
     */
    public Individual create(int numberOfGenes) {
        return new Individual(numberOfGenes);
    }
}
