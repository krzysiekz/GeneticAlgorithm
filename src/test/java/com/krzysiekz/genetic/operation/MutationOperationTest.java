package com.krzysiekz.genetic.operation;

import com.krzysiekz.genetic.Individual;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MutationOperationTest {

    public static final long SEED = 12345l;
    public static final double PROBABILITY_OF_MUTATION = 0.5;
    public static final int NUMBER_OF_GENES = 4;

    @Test
    public void shouldPerformMutation() {
        //given
        Individual individual = new Individual(NUMBER_OF_GENES);
        individual.setGenes(new byte[]{1,1,1,1});
        MutationOperation mutationOperation = new MutationOperation(SEED);
        //when
        mutationOperation.apply(individual, PROBABILITY_OF_MUTATION);
        //then
        assertThat(individual.getGenes()).isEqualTo(new byte[]{0,1,1,0});
    }
}
