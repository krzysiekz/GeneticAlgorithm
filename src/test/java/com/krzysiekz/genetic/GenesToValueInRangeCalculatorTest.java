package com.krzysiekz.genetic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GenesToValueInRangeCalculatorTest {
    @Test
    public void shouldCalculateProperValueForMinimumRange() {
        //given
        Individual individual = mock(Individual.class);
        GenesToValueInRangeCalculator converter = new GenesToValueInRangeCalculator(0.5, 2.5);
        //when
        when(individual.getGenes()).thenReturn(new byte[]{0,0,0,0});
        Double value = converter.convert(individual);
        //then
        assertThat(value).isEqualTo(0.5, offset(0.001));
    }

    @Test
    public void shouldCalculateProperValueForMaximumRange() {
        //given
        Individual individual = mock(Individual.class);
        GenesToValueInRangeCalculator converter = new GenesToValueInRangeCalculator(0.5, 2.5);
        //when
        when(individual.getGenes()).thenReturn(new byte[]{1,1,1,1});
        Double value = converter.convert(individual);
        //then
        assertThat(value).isEqualTo(2.5, offset(0.001));
    }

}
