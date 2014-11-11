package com.krzysiekz.genetic;

import com.krzysiekz.genetic.operation.CrossoverOperation;
import com.krzysiekz.genetic.operation.MutationOperation;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class GeneticAlgorithm {
    private Population population;
    private Random random;

    public GeneticAlgorithm(Population population, long seed) {
        this.population = population;
        random = new Random(seed);
    }

    public GeneticAlgorithm(Population population) {
        this.population = population;
        random = new Random();
    }

    public void apply(GenesToValueCalculator genesToValueCalculator,
                      GeneticAlgorithmOptions options,
                      GeneticAlgorithmOperations operations) {

        population.calculateFitnessForIndividuals(options.getFitnessFunction(), genesToValueCalculator);
        for (int i = 0; i < options.getNumberOfGenerations(); i++) {
            population = options.getSelectionAlgorithm().createNewPopulation(population);
            performCrossover(options.getCrossoverProbability(), operations.getCrossoverOperation());
            performMutation(operations.getMutationOperation(), options.getMutationProbability());
            population.calculateFitnessForIndividuals(options.getFitnessFunction(), genesToValueCalculator);

            displayLogMessage(i);
        }
    }

    private void displayLogMessage(int i) {
        Logger.getAnonymousLogger().info(MessageFormat.
                format("Generation: {0}, average fitness: {1}, best fitness {2}",
                        i + 1, population.getTotalFitness() / population.getIndividuals().length,
                        population.getBestFitness()));
    }

    private void performMutation(MutationOperation mutationOperation, Double mutationProbability) {
        for (Individual individual : population.getIndividuals()) {
            mutationOperation.apply(individual, mutationProbability);
        }
    }

    private void performCrossover(double crossoverProbability, CrossoverOperation crossoverOperation) {
        List<Individual> individuals = getIndividualsForCrossover(population, crossoverProbability);
        performCrossoverOnSelectedIndividuals(crossoverOperation, individuals);
    }

    private List<Individual> getIndividualsForCrossover(Population newPopulation, double crossoverProbability) {
        List<Individual> individuals = new ArrayList<>();
        for (Individual individual : newPopulation.getIndividuals()) {
            if(random.nextDouble() < crossoverProbability) {
                individuals.add(individual);
            }
        }
        return individuals;
    }

    private void performCrossoverOnSelectedIndividuals(CrossoverOperation crossoverOperation, List<Individual> individuals) {
        while(individuals.size() >= 2) {
            Individual individualA = individuals.get(random.nextInt(individuals.size()));
            Individual individualB = individuals.get(random.nextInt(individuals.size()));
            crossoverOperation.apply(individualA, individualB);
            individuals.remove(individualA);
            individuals.remove(individualB);
        }
    }
}
