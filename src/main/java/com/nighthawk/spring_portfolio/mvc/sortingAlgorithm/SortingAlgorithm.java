package com.nighthawk.spring_portfolio.mvc.sortingAlgorithm;

import java.util.HashMap;

public class SortingAlgorithm {
    protected int swaps;
    protected int comparisons;
    protected long executionTime;

    public SortingAlgorithm() {
        this.swaps = 0;
        this.comparisons = 0;
        this.executionTime = 0;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getComparisons() {
        return comparisons;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public Integer[][] sort(HashMap<Integer, Integer[]> colorValues, int chosenColor) {
        long startTime = System.nanoTime();
        Integer[][] steps = performSort(colorValues, chosenColor);
        long endTime = System.nanoTime();
        executionTime = endTime - startTime;
        return steps;
    }

    protected Integer[][] performSort(HashMap<Integer, Integer[]> colorValues, int chosenColor) {
        // to be implemented by each sorting algorithm
        return null;
    }

    protected void swap(Integer[] array, Integer i, Integer j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        swaps++;
    }

    protected int compare(HashMap<Integer, Integer[]> colorValues, int i, int j, int chosenColor) {
        comparisons++;
        return Integer.compare(colorValues.get(i)[chosenColor], colorValues.get(j)[chosenColor]);
    }
}