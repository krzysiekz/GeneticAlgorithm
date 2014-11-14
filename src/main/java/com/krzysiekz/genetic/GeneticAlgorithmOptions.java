package com.krzysiekz.genetic;

import com.krzysiekz.genetic.fitness.FitnessFunction;
import com.krzysiekz.genetic.selection.SelectionAlgorithm;

/**
 * The class holds Genetic algorithm options.
 */
public class GeneticAlgorithmOptions {
    private int numberOfGenerations;
    private double crossoverProbability;
    private double mutationProbability;
    private SelectionAlgorithm selectionAlgorithm;
    private FitnessFunction fitnessFunction;

    /**
     * Instantiates a new Genetic algorithm options.
     *
     * @param numberOfGenerations the number of generations
     * @param crossoverProbability the crossover probability
     * @param mutationProbability the mutation probability
     * @param selectionAlgorithm the selection algorithm
     * @param fitnessFunction the fitness function
     */
    public GeneticAlgorithmOptions(int numberOfGenerations,
                                   double crossoverProbability, double mutationProbability,
                                   SelectionAlgorithm selectionAlgorithm, FitnessFunction fitnessFunction) {
        this.numberOfGenerations = numberOfGenerations;
        this.crossoverProbability = crossoverProbability;
        this.mutationProbability = mutationProbability;
        this.selectionAlgorithm = selectionAlgorithm;
        this.fitnessFunction = fitnessFunction;
    }

    /**
     * Gets number of generations.
     *
     * @return the number of generations
     */
    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    /**
     * Gets crossover probability.
     *
     * @return the crossover probability
     */
    public double getCrossoverProbability() {
        return crossoverProbability;
    }

    /**
     * Gets mutation probability.
     *
     * @return the mutation probability
     */
    public double getMutationProbability() {
        return mutationProbability;
    }

    /**
     * Gets selection algorithm.
     *
     * @return the selection algorithm
     */
    public SelectionAlgorithm getSelectionAlgorithm() {
        return selectionAlgorithm;
    }

    /**
     * Gets fitness function.
     *
     * @return the fitness function
     */
    public FitnessFunction getFitnessFunction() {
        return fitnessFunction;
    }
}
