package com.krzysiekz.genetic;

import com.krzysiekz.genetic.fitness.FitnessFunction;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class IndividualTest {

    private static final int NUMBER_OF_GENES = 20;
    private static final int DEFAULT_NUMBER_OF_GENES = 64;

    @Test
    public void shouldHaveGenes() {
        //given
        //when
        Individual individual = new Individual(NUMBER_OF_GENES);
        //then
        assertThat(individual.getGenes()).hasSize(NUMBER_OF_GENES);
    }

    @Test
    public void shouldHaveDefaultNumberOfGenesWhenNotProvided() {
        //given
        //when
        Individual individual = new Individual();
        //then
        assertThat(individual.getGenes()).hasSize(DEFAULT_NUMBER_OF_GENES);
    }

    @Test
    public void shouldInitializeItsGenesWithRandomValues() {
        //given
        Individual individual = new Individual(NUMBER_OF_GENES);
        Individual spy = Mockito.spy(individual);
        //when
        spy.initializeGenes();
        //then
        verify(spy, times(NUMBER_OF_GENES)).getRandomGenValue();
    }

    @Test
    public void shouldCalculateItsFitness() {
        //given
        GenesToValueInRangeCalculator calculator = mock(GenesToValueInRangeCalculator.class);
        FitnessFunction fitnessFunction = mock(FitnessFunction.class);
        Individual individual = new Individual();
        //when
        when(fitnessFunction.calculate(any(Individual.class),
                any(GenesToValueInRangeCalculator.class))).thenReturn(5.0);
        individual.calculateFitness(fitnessFunction, calculator);
        //then
        verify(fitnessFunction).calculate(any(Individual.class),
                any(GenesToValueInRangeCalculator.class));
        assertThat(individual.getFitness()).isEqualTo(5.0);
    }

    @Test
    public void shouldSetGeneOnIndividual() {
        //given
        Individual individual = new Individual();
        //when
        individual.initializeGenes();
        individual.setGene(1, (byte) 0);
        //then
        assertThat(individual.getGene(1)).isEqualTo((byte)0);
    }
}