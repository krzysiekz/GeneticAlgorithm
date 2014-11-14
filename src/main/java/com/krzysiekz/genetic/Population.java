package com.krzysiekz.genetic;

import com.krzysiekz.genetic.fitness.FitnessFunction;

/**
 * The class represents Population.
 */
public class Population {
    private final Individual[] individuals;

    /**
     * Instantiates a new Population.
     *
     * @param individualCreator the individual creator
     * @param numberOfIndividuals the number of individuals
     */
    public Population(IndividualCreator individualCreator, int numberOfIndividuals) {
        individuals = new Individual[numberOfIndividuals];
        for (int i = 0; i < numberOfIndividuals; i++) {
            individuals[i] = individualCreator.create();
            individuals[i].initializeGenes();
        }
    }

    /**
     * Instantiates a new Population.
     *
     * @param individualCreator the individual creator
     * @param numberOfIndividuals the number of individuals
     * @param numberOfGenes the number of genes
     */
    public Population(IndividualCreator individualCreator, int numberOfIndividuals, int numberOfGenes) {
        individuals = new Individual[numberOfIndividuals];
        for (int i = 0; i < numberOfIndividuals; i++) {
            individuals[i] = individualCreator.create(numberOfGenes);
            individuals[i].initializeGenes();
        }
    }

    /**
     * Instantiates a new Population.
     *
     * @param numberOfIndividuals the number of individuals
     */
    public Population(int numberOfIndividuals) {
        individuals = new Individual[numberOfIndividuals];
    }

    /**
     * Get individuals.
     *
     * @return the individual [ ]
     */
    public Individual[] getIndividuals() {
        return individuals;
    }

    /**
     * Calculates fitness for individuals.
     *
     * @param fitnessFunction the fitness function
     * @param calculator the genes to value calculator
     */
    public void calculateFitnessForIndividuals(FitnessFunction fitnessFunction,
                                               GenesToValueCalculator calculator) {
        for(Individual individual : individuals) {
            individual.calculateFitness(fitnessFunction, calculator);
        }
    }

    /**
     * Gets total fitness.
     *
     * @return the total fitness
     */
    public Double getTotalFitness() {
        Double totalFitness = 0.0;
        for(Individual individual : individuals) {
            totalFitness += individual.getFitness();
        }
        return totalFitness;
    }

    /**
     * Sets individual.
     *
     * @param index the index
     * @param individual the individual
     */
    public void setIndividual(int index, Individual individual) {
        individuals[index] = individual;
    }

    /**
     * Gets best individual.
     *
     * @return the best individual
     */
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
