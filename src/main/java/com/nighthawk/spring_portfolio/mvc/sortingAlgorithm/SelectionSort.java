package com.nighthawk.spring_portfolio.mvc.sortingAlgorithm;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class SelectionSort extends SortingAlgorithm {
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
        // selection sort
        for (int i = 0; i < colorValues.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < colorValues.size(); j++) {
                if (compare(colorValues, indices[j], indices[minIndex], chosenColor) < 0) {
                    minIndex = j;
                }
            }
            swap(indices, i, minIndex);
            // copying the current state of indices to the steps list
            stepsList.add(Arrays.copyOf(indices, indices.length));
        }
        // converting the ArrayList to a 2D array when returning, as all do
        return stepsList.toArray(new Integer[0][]);
    }
}