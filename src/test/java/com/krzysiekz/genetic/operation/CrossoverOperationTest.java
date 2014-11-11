package com.krzysiekz.genetic.operation;

import com.krzysiekz.genetic.Individual;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CrossoverOperationTest {

    @Test
    public void shouldPerformCrossover() {
        //given
        Individual individualA = new Individual(4);
        individualA.setGenes(new byte[]{1,1,1,1});

        Individual individualB = new Individual(4);
        individualB.setGenes(new byte[]{0,0,0,0});
        CrossoverOperation operation = new CrossoverOperation(12345l);
        //when
        operation.apply(individualA, individualB);
        //then
        assertThat(individualA.getGenes()).isEqualTo(new byte[]{1,0,0,0});
        assertThat(individualB.getGenes()).isEqualTo(new byte[]{0,1,1,1});
    }
}
