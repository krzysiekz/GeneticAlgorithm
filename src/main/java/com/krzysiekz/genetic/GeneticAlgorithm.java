package com.krzysiekz.genetic;

import com.krzysiekz.genetic.operation.CrossoverOperation;
import com.krzysiekz.genetic.operation.MutationOperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * The class that represents genetic algorithm.
 */
public class GeneticAlgorithm {
    private Population population;
    private Random random;

    /**
     * Instantiates a new genetic algorithm.
     *
     * @param population the population
     */
    public GeneticAlgorithm(Population population) {
        this.population = population;
        random = new Random();
    }

    /**
     * Applies genetic algorithm on population.
     *
     * @param genesToValueCalculator the genes to value calculator
     * @param options the genetic algorithm options
     * @param operations the genetic algorithm operations
     * @param outputFileName the output file name
     */
    public void apply(GenesToValueCalculator genesToValueCalculator,
                      GeneticAlgorithmOptions options,
                      GeneticAlgorithmOperations operations,
                      String outputFileName) {
        try (PrintWriter pw = new PrintWriter(outputFileName)) {
            population.calculateFitnessForIndividuals(options.getFitnessFunction(), genesToValueCalculator);
            for (int i = 0; i < options.getNumberOfGenerations(); i++) {
                population = options.getSelectionAlgorithm().createNewPopulation(population);
                performCrossover(options.getCrossoverProbability(), operations.getCrossoverOperation());
                performMutation(operations.getMutationOperation(), options.getMutationProbability());
                population.calculateFitnessForIndividuals(options.getFitnessFunction(), genesToValueCalculator);

                displayLogMessage(i, genesToValueCalculator);
                writeResultToFile(genesToValueCalculator, pw, i);
            }
        } catch (IOException e) {
            Logger.getAnonymousLogger().
                    severe(MessageFormat.format("Cannot save result to the file. {0}", e.getMessage()));
        }
    }

    private void writeResultToFile(GenesToValueCalculator genesToValueCalculator, PrintWriter pw, int i) {
        Individual bestIndividual = population.getBestIndividual();
        pw.printf("%d\t%f\t%f\t%f%n", i+1,
                population.getTotalFitness() / population.getIndividuals().length,
                bestIndividual.getFitness(), genesToValueCalculator.convert(bestIndividual));
    }

    private void displayLogMessage(int i, GenesToValueCalculator genesToValueCalculator) {
        Individual bestIndividual = population.getBestIndividual();
        Logger.getAnonymousLogger().info(MessageFormat.
                format("Generation: {0}, average fitness: {1}, best fitness {2} for x: {3}",
                        i + 1, population.getTotalFitness() / population.getIndividuals().length,
                        bestIndividual.getFitness(), genesToValueCalculator.convert(bestIndividual)));
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
