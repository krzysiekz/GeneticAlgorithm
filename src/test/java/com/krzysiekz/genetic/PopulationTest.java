package com.krzysiekz.genetic;

import com.krzysiekz.genetic.fitness.FitnessFunction;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
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

    @Test
    public void shouldCalculateFitnessForAllIndividuals() {
        //given
        GenesToValueInRangeCalculator calculator = mock(GenesToValueInRangeCalculator.class);
        FitnessFunction fitnessFunction = mock(FitnessFunction.class);
        //when
        when(individualCreator.create()).thenReturn(individual);
        Population population = new Population(individualCreator, NUMBER_OF_INDIVIDUALS);
        population.calculateFitnessForIndividuals(fitnessFunction, calculator);
        //then
        verify(individual, times(NUMBER_OF_INDIVIDUALS)).calculateFitness(fitnessFunction, calculator);
    }

    @Test
    public void shouldCalculateTotalFitness() {
        //when
        when(individual.getFitness()).thenReturn(5.0);
        when(individualCreator.create()).thenReturn(individual);
        Population population = new Population(individualCreator, NUMBER_OF_INDIVIDUALS);
        Double totalFitness = population.getTotalFitness();
        //then
        assertThat(totalFitness).isEqualTo(50, offset(0.0001));
    }

    @Test
    public void shouldSetIndividualWIthIndex() {
        //given
        Population population = new Population(NUMBER_OF_INDIVIDUALS);
        //when
        population.setIndividual(1, individual);
        //then
        assertThat(population.getIndividuals()[1]).isEqualTo(individual);
    }
}
