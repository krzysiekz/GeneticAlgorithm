package com.krzysiekz.genetic.selection.impl;

import com.krzysiekz.genetic.Individual;
import com.krzysiekz.genetic.Population;
import com.krzysiekz.genetic.selection.SelectionAlgorithm;

/**
 * The class that represents tournament selection algorithm.
 */
public class TournamentSelectionAlgorithm implements SelectionAlgorithm {
    private final int tournamentSize;

    /**
     * Instantiates a new tournament selection algorithm.
     *
     * @param tournamentSize the tournament size
     */
    public TournamentSelectionAlgorithm(int tournamentSize) {
        this.tournamentSize = tournamentSize;
    }

    /**
     * Creates new population.
     *
     * @param population the population
     * @return the population
     */
    @Override
    public Population createNewPopulation(Population population) {
        Population newPopulation = new Population(population.getIndividuals().length);
        for (int i = 0; i < population.getIndividuals().length; i++) {
            newPopulation.setIndividual(i, new Individual(getIndividualFromTournament(population)));
        }
        return newPopulation;
    }

    private Individual getIndividualFromTournament(Population population) {
        Individual tournament[] = new Individual[tournamentSize];
        for (int i = 0; i < tournamentSize; i++) {
            int index = (int) (Math.random() * population.getIndividuals().length);
            tournament[i] = population.getIndividuals()[index];
        }
        return geTheBestIndividual(tournament);
    }

    private Individual geTheBestIndividual(Individual[] tournament) {
        Individual bestIndividual = tournament[0];
        for (Individual individual : tournament) {
            if(individual.getFitness() > bestIndividual.getFitness()) {
                bestIndividual = individual;
            }
        }
        return bestIndividual;
    }
}
