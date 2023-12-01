package com.nighthawk.spring_portfolio.mvc.sortingAlgorithm;

import java.util.HashMap;
/*
 * Sample RGB HashMap example in JSON:
 * {
 *     0: (this is the id of the color in the palette)
 *         {200 (red value), 120 (green value), 10 (blue value)},
 *     1: {20, 34, 120},
 *     ...
 * }
*/

public class SortRequest {
    private HashMap<Integer, Integer[]> rgbData;
    private Integer color;
    private String sortType;
    private boolean big;

    public SortRequest(Integer id, HashMap<Integer, Integer[]> rgbData, Integer color, String sortType, boolean big) {
        this.rgbData = rgbData; // change to hashmap
        this.color = color; // represented by an Integer: 0 = red, 1 = green, 2 = blue
        this.sortType = sortType; // "bubble", "selection", "insertion", "merge"
        this.big = big; // true if 5000 are being sorted, false otherwise
    }

    public void setRgbData(HashMap<Integer, Integer[]> rgbData) {
        this.rgbData = rgbData;
    }
    
    public void setColor(Integer color) {
        this.color = color;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public void setBig(boolean big) {
        this.big = big;
    }

    public HashMap<Integer, Integer[]> getRgbData() {
        return this.rgbData;
    }

    public Integer getColor() {
        return this.color;
    }

    public String getSortType() {
        return this.sortType;
    }

    public boolean getBig() {
        return this.big;
    }
}
