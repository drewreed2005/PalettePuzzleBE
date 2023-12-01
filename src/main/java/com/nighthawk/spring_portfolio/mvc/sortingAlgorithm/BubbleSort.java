package com.nighthawk.spring_portfolio.mvc.sortingAlgorithm;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class BubbleSort extends SortingAlgorithm {
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
        // bubble sort
        for (int i = 0; i < colorValues.size(); i++) {
            boolean swapped = false; // flag to track whether any swaps were made in this pass
            for (int j = 0; j < colorValues.size() - i - 1; j++) {
                if (compare(colorValues, indices[j], indices[j + 1], chosenColor) > 0) {
                    swap(indices, j, j + 1);
                    swapped = true;
                }
            }
            // if no swaps were made in this pass, the array is already sorted so we break out of the loop
            if (!swapped) {
                break;
            }
            // copying the current state of indices to the steps list
            stepsList.add(Arrays.copyOf(indices, indices.length));
        }
        // converting the ArrayList to a 2D array
        //Integer[][] steps = stepsList.toArray(new Integer[0][]);
        return stepsList.toArray(new Integer[0][]);
    }
}
