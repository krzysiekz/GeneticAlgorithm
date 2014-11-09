package com.krzysiekz.genetic;

public class Population {
    private final Individual[] individuals;

    public Population(IndividualCreator individualCreator, int numberOfIndividuals) {
        individuals = new Individual[numberOfIndividuals];
        for (int i = 0; i < numberOfIndividuals; i++) {
            individuals[i] = individualCreator.create();
            individuals[i].initializeGenes();
        }
    }

    public Population(IndividualCreator individualCreator, int numberOfIndividuals, int numberOfGenes) {
        individuals = new Individual[numberOfIndividuals];
        for (int i = 0; i < numberOfIndividuals; i++) {
            individuals[i] = individualCreator.create(numberOfGenes);
            individuals[i].initializeGenes();
        }
    }

    public Individual[] getIndividuals() {
        return individuals;
    }
}
