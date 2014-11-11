package com.krzysiekz.genetic.selection.impl;

import com.krzysiekz.genetic.Individual;
import com.krzysiekz.genetic.Population;
import com.krzysiekz.genetic.selection.SelectionAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class RouletteSelectionAlgorithm implements SelectionAlgorithm {

    private final Map<Integer, Double> individualsProbability = new HashMap<>();
    private final Map<Integer, Double> individualsDistribution = new HashMap<>();

    @Override
    public Population createNewPopulation(Population population) {
        calculateProbabilities(population);
        calculateDistributions(population);
        Population newPopulation = new Population(population.getIndividuals().length);
        for (int i = 0; i < population.getIndividuals().length; i++) {
            Double randomValue = Math.random();
            int index = findIndividual(randomValue);
            newPopulation.setIndividual(i, new Individual(population.getIndividuals()[index]));
        }
        return newPopulation;
    }

    private int findIndividual(Double randomValue) {
        for(Integer i = 1 ; i < individualsDistribution.size(); i++) {
            if(randomValue <= individualsDistribution.get(i)
                    && randomValue > individualsDistribution.get(i-1)) {
                return i-1;
            }
        }
        return 0;
    }

    private void calculateDistributions(Population population) {
        Double distribution = 0.0;
        individualsDistribution.put(0, distribution);
        Individual[] individuals = population.getIndividuals();
        for(int i = 0 ; i < individuals.length ; i++) {
            distribution += individualsProbability.get(i+1);
            individualsDistribution.put(i+1, distribution);
        }
    }

    private void calculateProbabilities(Population population) {
        Double totalFitness = population.getTotalFitness();
        Individual[] individuals = population.getIndividuals();
        for(int i = 0 ; i < individuals.length ; i++) {
            individualsProbability.put(i+1, individuals[i].getFitness()/totalFitness);
        }
    }
}
