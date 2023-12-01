package com.nighthawk.spring_portfolio.mvc.sortingAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import com.nighthawk.spring_portfolio.mvc.sortingAlgorithm.SortingAlgorithm;
// import com.nighthawk.spring_portfolio.mvc.sortingAlgorithm.SortRequest;

@RestController
@RequestMapping("/api/sortingAlgorithm") // Sets the path to our dijkstra algorithm
public class SortingAlgorithmApiController {
    // private JSONObject body; //last run result
    // private HttpStatus status; //last run status
    String last_run = null; //last run day of month

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Object> sortColors(@RequestBody SortRequest request) {
        String chosenSort = request.getSortType();
        HashMap<Integer, Integer[]> data = request.getRgbData();
        Integer chosenColor = request.getColor();
        boolean big = request.getBig();
        HashMap<String, Object> returnValue = new HashMap<String, Object>();
        Integer[][] steps = null;
        // for general sorts, creating steps to show/replay process
        switch (chosenSort) {
            case "bubble":
                BubbleSort bubbleSort = new BubbleSort();
                steps = bubbleSort.sort(data, chosenColor);
                break;
            case "selection":
                SelectionSort selectionSort = new SelectionSort();
                steps = selectionSort.sort(data, chosenColor);
                break;
            case "insertion":
                InsertionSort insertionSort = new InsertionSort();
                steps = insertionSort.sort(data, chosenColor);
                break;
            case "merge":
                MergeSort mergeSort = new MergeSort();
                steps = mergeSort.sort(data, chosenColor);
                break;
        }
        // if being used for the big 5000 sort, for data returning
        if (big) {
            // initializing all sort types and variable for average runtime
            SortingAlgorithm bigBubbleSort = new BubbleSort();
            SortingAlgorithm bigSelectionSort = new SelectionSort();
            SortingAlgorithm bigInsertionSort = new InsertionSort();
            SortingAlgorithm bigMergeSort = new MergeSort();
            SortingAlgorithm[] algorithmArray = {bigBubbleSort, bigSelectionSort, bigInsertionSort, bigMergeSort};
            long[] averageTimes = {0, 0, 0, 0}; // indexes: 0 = bubble, 1 = selection, 2 = insertion, 3 = merge
            // 100 sorts
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 4; j++) {
                    algorithmArray[j].sort(data, chosenColor);
                    averageTimes[j] += (algorithmArray[j].getExecutionTime() * 0.01);
                }
            }
            ArrayList<HashMap<String, Long>> analysisArray = new ArrayList<>();
            for (int k = 0; k < 4; k++) {
                analysisArray.add(new HashMap<String, Long>());
                analysisArray.get(k).put("averageTime", averageTimes[k]);
                analysisArray.get(k).put("swaps", (long) algorithmArray[k].getSwaps());
                analysisArray.get(k).put("comparisons", (long) algorithmArray[k].getComparisons());
            }
            returnValue.put("bubble", analysisArray.get(0));
            returnValue.put("selection", analysisArray.get(1));
            returnValue.put("insertion", analysisArray.get(2));
            returnValue.put("merge", analysisArray.get(3));
        }
        returnValue.put("steps", steps);

        return new ResponseEntity<>(returnValue, HttpStatus.OK);
    }
}
