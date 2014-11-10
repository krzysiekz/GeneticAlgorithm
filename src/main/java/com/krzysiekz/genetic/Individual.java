package com.krzysiekz.genetic;

public class Individual {

    private static final int DEFAULT_NUMBER_OF_GENES = 64;
    private final byte[] genes;

    public Individual(int numberOfGenes) {
        genes = new byte[numberOfGenes];
    }

    public Individual() {
        genes = new byte[DEFAULT_NUMBER_OF_GENES];
    }

    public byte[] getGenes() {
        return genes;
    }

    public void initializeGenes() {
        for (int i = 0; i < genes.length; i++) {
            genes[i] = getRandomGenValue();
        }
    }

    byte getRandomGenValue() {
        return (byte) Math.round(Math.random());
    }
}
