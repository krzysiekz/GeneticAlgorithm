package com.krzysiekz.genetic;

import com.krzysiekz.genetic.fitness.FitnessFunction;
import com.krzysiekz.genetic.selection.SelectionAlgorithm;

public class GeneticAlgorithmOptions {
    private int numberOfGenerations;
    private double crossoverProbability;
    private double mutationProbability;
    private SelectionAlgorithm selectionAlgorithm;
    private FitnessFunction fitnessFunction;

    public GeneticAlgorithmOptions(int numberOfGenerations,
                                   double crossoverProbability, double mutationProbability,
                                   SelectionAlgorithm selectionAlgorithm, FitnessFunction fitnessFunction) {
        this.numberOfGenerations = numberOfGenerations;
        this.crossoverProbability = crossoverProbability;
        this.mutationProbability = mutationProbability;
        this.selectionAlgorithm = selectionAlgorithm;
        this.fitnessFunction = fitnessFunction;
    }

    public int getNumberOfGenerations() {
        return numberOfGenerations;
    }

    public double getCrossoverProbability() {
        return crossoverProbability;
    }

    public double getMutationProbability() {
        return mutationProbability;
    }

    public SelectionAlgorithm getSelectionAlgorithm() {
        return selectionAlgorithm;
    }

    public FitnessFunction getFitnessFunction() {
        return fitnessFunction;
    }
}
