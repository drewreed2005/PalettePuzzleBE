package com.nighthawk.spring_portfolio.mvc.sortingAlgorithm;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class MergeSort extends SortingAlgorithm {
    @Override
    protected Integer[][] performSort(HashMap<Integer, Integer[]> colorValues, int chosenColor) {
        ArrayList<Integer[]> steps = new ArrayList<>();
        Integer[] indexes = new Integer[colorValues.size()];
        // initialize indexes array with sorted order
        for (int i = 0; i < colorValues.size(); i++) {
            indexes[i] = i;
        }
        mergeSort(indexes, colorValues, chosenColor, steps);
        // convert ArrayList to 2D array to be returned
        return steps.toArray(new Integer[0][]);
    }

    private void mergeSort(Integer[] array, HashMap<Integer, Integer[]> colorValues, Integer chosenColor, ArrayList<Integer[]> steps) {
        if (array.length <= 1) {
            return; // indicates that it's already sorted
        }
        // splitting the array into two halves
        Integer mid = array.length / 2;
        Integer[] leftArray = Arrays.copyOfRange(array, 0, mid);
        Integer[] rightArray = Arrays.copyOfRange(array, mid, array.length);
        // recursively sorting each half
        mergeSort(leftArray, colorValues, chosenColor, steps);
        mergeSort(rightArray, colorValues, chosenColor, steps);
        // merging the sorted halves
        merge(array, leftArray, rightArray, colorValues, chosenColor, steps);
    }

    private void merge(Integer[] array, Integer[] leftArray, Integer[] rightArray, HashMap<Integer, Integer[]> colorValues, Integer chosenColor, ArrayList<Integer[]> steps) {
        int leftIndex = 0, rightIndex = 0, arrayIndex = 0;
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            Integer leftKey = leftArray[leftIndex];
            Integer rightKey = rightArray[rightIndex];
            // comparing the chosen color channel values
            Integer leftColorValue = colorValues.get(leftKey)[chosenColor];
            Integer rightColorValue = colorValues.get(rightKey)[chosenColor];
            comparisons++;
            if (leftColorValue <= rightColorValue) {
                array[arrayIndex++] = leftKey;
                leftIndex++;
            } else {
                array[arrayIndex++] = rightKey;
                rightIndex++;
            }
        }
        // copying remaining elements from leftArray
        while (leftIndex < leftArray.length) {
            swaps++;
            array[arrayIndex++] = leftArray[leftIndex++];
        }
        // copying remaining elements from rightArray
        while (rightIndex < rightArray.length) {
            swaps++;
            array[arrayIndex++] = rightArray[rightIndex++];
        }
        // add current state of sort to steps
        steps.add(Arrays.copyOf(array, array.length));
    }
}