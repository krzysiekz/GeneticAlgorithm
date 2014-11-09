package com.krzysiekz.genetic;

public class IndividualCreator {

    public Individual create() {
        return new Individual();
    }

    public Individual create(int numberOfGenes) {
        return new Individual(numberOfGenes);
    }
}
