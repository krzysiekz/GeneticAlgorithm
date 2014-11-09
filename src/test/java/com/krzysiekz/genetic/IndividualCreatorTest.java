package com.krzysiekz.genetic;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IndividualCreatorTest {

    private static final int NUMBER_OF_GENES = 20;
    private IndividualCreator individualCreator;

    @Before
    public void setUp() {
        individualCreator = new IndividualCreator();
    }

    @Test
    public void shouldCreateIndividual() {
        //when
        Individual individual = individualCreator.create();
        //then
        assertThat(individual).isNotNull().isExactlyInstanceOf(Individual.class);
    }

    @Test
    public void shouldCreateIndividualWithSpecificNumberOfGenes() {
        //when
        Individual individual = individualCreator.create(NUMBER_OF_GENES);
        //then
        assertThat(individual).isNotNull().isExactlyInstanceOf(Individual.class);
        assertThat(individual.getGenes()).hasSize(NUMBER_OF_GENES);
    }
}
