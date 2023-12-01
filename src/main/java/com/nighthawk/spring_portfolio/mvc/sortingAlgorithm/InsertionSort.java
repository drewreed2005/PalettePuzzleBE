package com.nighthawk.spring_portfolio.mvc.sortingAlgorithm;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class InsertionSort extends SortingAlgorithm {
    @Override
    protected Integer[][] performSort(HashMap<Integer, Integer[]> colorValues, int chosenColor) {
        ArrayList<Integer[]> stepsList = new ArrayList<>();
        // copying the original array indices to the first step
        Integer[] initialIndices = new Integer[colorValues.size()];
        for (int i = 0; i < colorValues.size(); i++) {
            initialIndices[i] = i;
        }
        stepsList.add(Arrays.copyOf(initialIndices, initialIndices.length));
        Integer[] indices = Arrays.copyOf(initialIndices, initialIndices.length);
        // insertion sort
        for (int i = 1; i < colorValues.size(); i++) {
            int key = indices[i];
            int j = i - 1;
            // moving elements of indices that are greater than key one position ahead of their current position
            while (j >= 0 && compare(colorValues, indices[j], key, chosenColor) > 0) {
                indices[j + 1] = indices[j];
                j = j - 1;
                swaps++;
            }
            indices[j + 1] = key;
            // copying the current state of indices to the steps list
            stepsList.add(Arrays.copyOf(indices, indices.length));
        }
        return stepsList.toArray(new Integer[0][]);
    }
}