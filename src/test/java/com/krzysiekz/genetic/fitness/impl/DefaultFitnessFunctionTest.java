package com.krzysiekz.genetic.fitness.impl;

import com.krzysiekz.genetic.GenesToValueCalculator;
import com.krzysiekz.genetic.Individual;
import com.krzysiekz.genetic.fitness.FitnessFunction;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultFitnessFunctionTest {

    private Individual individual;
    private FitnessFunction fitnessFunction;
    private GenesToValueCalculator converter;

    @Before
    public void setUp() {
        individual = mock(Individual.class);
        converter = mock(GenesToValueCalculator.class);
        fitnessFunction = new DefaultFitnessFunction();
    }

    @Test
    public void shouldReturnValidValueForMaximumGenes() {
        //when
        when(converter.convert(individual)).thenReturn(2.5);
        Double fitnessValue = fitnessFunction.calculate(individual, converter);
        //then
        assertThat(fitnessValue).isEqualTo(0.4, offset(0.001));
    }

    @Test
    public void shouldReturnValidValueForMinimumGenes() {
        //when
        when(converter.convert(individual)).thenReturn(0.5);
        Double fitnessValue = fitnessFunction.calculate(individual, converter);
        //then
        assertThat(fitnessValue).isEqualTo(2, offset(0.001));
    }
}
