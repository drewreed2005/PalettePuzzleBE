package com.nighthawk.spring_portfolio.mvc.palette;

import java.util.

public class Palette {
    public int[][] bubbleSort(int[][] colorValues) {
        int[][] sortedArray = colorValues.clone();  // copying the orginal array
        int n = sortedArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    // swap values
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }
        return sortedArray;
    }
}
