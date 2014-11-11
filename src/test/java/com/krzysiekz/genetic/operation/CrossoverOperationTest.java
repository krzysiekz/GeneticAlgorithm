package com.krzysiekz.genetic.operation;

import com.krzysiekz.genetic.Individual;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CrossoverOperationTest {

    public static final long SEED = 12345l;
    public static final int NUMBER_OF_GENES = 4;

    @Test
    public void shouldPerformCrossover() {
        //given
        Individual individualA = new Individual(NUMBER_OF_GENES);
        individualA.setGenes(new byte[]{1,1,1,1});

        Individual individualB = new Individual(NUMBER_OF_GENES);
        individualB.setGenes(new byte[]{0,0,0,0});
        CrossoverOperation operation = new CrossoverOperation(SEED);
        //when
        operation.apply(individualA, individualB);
        //then
        assertThat(individualA.getGenes()).isEqualTo(new byte[]{1,0,0,0});
        assertThat(individualB.getGenes()).isEqualTo(new byte[]{0,1,1,1});
    }
}
