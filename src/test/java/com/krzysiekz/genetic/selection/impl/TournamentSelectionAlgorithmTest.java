package com.krzysiekz.genetic.selection.impl;

import com.krzysiekz.genetic.Individual;
import com.krzysiekz.genetic.Population;
import com.krzysiekz.genetic.selection.SelectionAlgorithm;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TournamentSelectionAlgorithmTest {
    @Test
    public void shouldCreateNewPopulation() {
        //given
        Individual individualA = mock(Individual.class);
        Individual individualB = mock(Individual.class);
        Population population = mock(Population.class);
        SelectionAlgorithm selectionAlgorithm = new TournamentSelectionAlgorithm(2);
        //when
        when(individualA.getGenes()).thenReturn(new byte[]{1,1,1,1});
        when(individualB.getGenes()).thenReturn(new byte[]{1,1,1,1});
        when(individualA.getFitness()).thenReturn(1.0);
        when(individualB.getFitness()).thenReturn(2.0);
        when(population.getIndividuals()).thenReturn(new Individual[]{individualA, individualB});
        Population newPopulation = selectionAlgorithm.createNewPopulation(population);
        //then
        assertThat(newPopulation).isNotNull();
    }
}
