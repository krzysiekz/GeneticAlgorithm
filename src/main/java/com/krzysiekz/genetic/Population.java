package com.krzysiekz.genetic;

import com.krzysiekz.genetic.fitness.FitnessFunction;

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

    public Population(int numberOfIndividuals) {
        individuals = new Individual[numberOfIndividuals];
    }

    public Individual[] getIndividuals() {
        return individuals;
    }

    public void calculateFitnessForIndividuals(FitnessFunction fitnessFunction,
                                               GenesToValueCalculator calculator) {
        for(Individual individual : individuals) {
            individual.calculateFitness(fitnessFunction, calculator);
        }
    }

    public Double getTotalFitness() {
        Double totalFitness = 0.0;
        for(Individual individual : individuals) {
            totalFitness += individual.getFitness();
        }
        return totalFitness;
    }

    public void setIndividual(int index, Individual individual) {
        individuals[index] = individual;
    }

    public Individual getBestIndividual() {
        Individual bestIndividual = individuals[0];
        for (Individual individual : individuals) {
            if(individual.getFitness() > bestIndividual.getFitness()) {
                bestIndividual = individual;
            }
        }
        return bestIndividual;
    }
}
