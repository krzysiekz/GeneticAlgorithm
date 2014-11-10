package com.krzysiekz.genetic;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberOfNeededGenesCalculatorTest {

    @Test
    public void shouldCalculateNumberOfNeededGenes() {
        //given
        NumberOfNeededGenesCalculator calculator = new NumberOfNeededGenesCalculator();
        //when
        //then
        assertThat(calculator.calculate(6, -1, 2)).isEqualTo(22);
        assertThat(calculator.calculate(3, 0.5, 2.5)).isEqualTo(11);
    }
}
