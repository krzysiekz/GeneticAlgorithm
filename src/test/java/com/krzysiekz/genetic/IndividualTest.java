package com.krzysiekz.genetic;

import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        verify(spy, times(NUMBER_OF_GENES)).getRandomGen();

    }
}