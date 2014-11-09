package com.krzysiekz.genetic;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PopulationTest {
    private static final int NUMBER_OF_INDIVIDUALS = 10;
    private static final int NUMBER_OF_GENES = 20;

    private Individual individual;
    private IndividualCreator individualCreator;

    @Before
    public void setUp() {
        individual = mock(Individual.class);
        individualCreator = mock(IndividualCreator.class);
    }

    @Test
    public void shouldHaveIndividuals() {
        //when
        when(individualCreator.create()).thenReturn(individual);
        Population population = new Population(individualCreator, NUMBER_OF_INDIVIDUALS);
        //then
        verify(individualCreator, times(NUMBER_OF_INDIVIDUALS)).create();
        assertThat(population.getIndividuals()).hasSize(NUMBER_OF_INDIVIDUALS).
                hasOnlyElementsOfType(Individual.class);
    }

    @Test
    public void shouldHaveIndividualsWithSpecificNumberOfGenes() {
        //when
        when(individualCreator.create(NUMBER_OF_GENES)).thenReturn(individual);
        new Population(individualCreator, NUMBER_OF_INDIVIDUALS, NUMBER_OF_GENES);
        //then
        verify(individualCreator, times(NUMBER_OF_INDIVIDUALS)).create(NUMBER_OF_GENES);
    }

    @Test
    public void shouldCallGenesInitializationWithNumbersOfGenes() {
        //when
        when(individualCreator.create(NUMBER_OF_GENES)).thenReturn(individual);
        new Population(individualCreator, NUMBER_OF_INDIVIDUALS, NUMBER_OF_GENES);
        //then
        verify(individual, times(NUMBER_OF_INDIVIDUALS)).initializeGenes();
    }

    @Test
    public void shouldCallGenesInitialization() {
        //when
        when(individualCreator.create()).thenReturn(individual);
        new Population(individualCreator, NUMBER_OF_INDIVIDUALS);
        //then
        verify(individual, times(NUMBER_OF_INDIVIDUALS)).initializeGenes();
    }
}
