package com.krzysiekz.genetic.selection;

import com.krzysiekz.genetic.Population;

public interface SelectionAlgorithm {
    Population createNewPopulation(Population population);
}
