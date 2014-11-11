package com.krzysiekz.genetic;

import com.krzysiekz.genetic.fitness.FitnessFunction;
import com.krzysiekz.genetic.fitness.impl.DefaultFitnessFunction;
import com.krzysiekz.genetic.operation.CrossoverOperation;
import com.krzysiekz.genetic.operation.MutationOperation;
import com.krzysiekz.genetic.selection.SelectionAlgorithm;
import com.krzysiekz.genetic.selection.impl.TournamentSelectionAlgorithm;

public class AlgorithmMain {

    public static final int NUMBER_OF_GENERATIONS = 500;
    public static final double CROSSOVER_PROBABILITY = 0.25;
    public static final double MUTATION_PROBABILITY = 0.01;
    public static final double MIN_RANGE = 0.5;
    public static final double MAX_RANGE = 2.5;
    public static final int PRECISION = 3;
    public static final int NUMBER_OF_INDIVIDUALS = 50;

    public static void main(String[] args) {
        GeneticAlgorithmOptions options = getGeneticAlgorithmOptions();
        GeneticAlgorithmOperations operations = getGeneticAlgorithmOperations();

        GenesToValueCalculator genesToValueCalculator = new GenesToValueCalculator(MIN_RANGE, MAX_RANGE);
        int numberOfNeededNeurons = new NumberOfNeededGenesCalculator().calculate(PRECISION, MIN_RANGE, MAX_RANGE);

        Population population = new Population(new IndividualCreator(), NUMBER_OF_INDIVIDUALS, numberOfNeededNeurons);

        GeneticAlgorithm algorithm = new GeneticAlgorithm(population);
        algorithm.apply(genesToValueCalculator, options, operations);
    }

    private static GeneticAlgorithmOperations getGeneticAlgorithmOperations() {
        CrossoverOperation crossoverOperation = new CrossoverOperation();
        MutationOperation mutationOperation = new MutationOperation();
        return new GeneticAlgorithmOperations(crossoverOperation, mutationOperation);
    }

    private static GeneticAlgorithmOptions getGeneticAlgorithmOptions() {
        SelectionAlgorithm selectionAlgorithm = new TournamentSelectionAlgorithm(2);
        FitnessFunction fitnessFunction = new DefaultFitnessFunction();
        return new GeneticAlgorithmOptions(NUMBER_OF_GENERATIONS,
                CROSSOVER_PROBABILITY, MUTATION_PROBABILITY, selectionAlgorithm, fitnessFunction);
    }
}
