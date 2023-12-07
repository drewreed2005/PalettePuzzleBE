package com.nighthawk.spring_portfolio.mvc.fibonacci;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// import com.nighthawk.spring_portfolio.mvc.sortingAlgorithm.SortingAlgorithm;
// import com.nighthawk.spring_portfolio.mvc.sortingAlgorithm.SortRequest;

@RestController
@RequestMapping("/api/fibonacci") // Sets the path to our dijkstra algorithm
public class FibonacciApiController {
    // private JSONObject body; //last run result
    // private HttpStatus status; //last run status
    String last_run = null; //last run day of month

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFibonacci(@PathVariable Integer id) {
        HashMap<String, HashMap<String, Object>> returnValue = new HashMap<String, HashMap<String, Object>>();
        GoldenRatio goldenRatio = new GoldenRatio();
        MatrixExponentiation matrixExponentiation = new MatrixExponentiation();
        ForLoop forLoop = new ForLoop();
        WhileLoop whileLoop = new WhileLoop();
        StreamLoop streamLoop = new StreamLoop();
        Fibonacci[] methodArray = {goldenRatio, matrixExponentiation, forLoop, whileLoop, streamLoop};
        for (Fibonacci method : methodArray) {
            long result = method.calculate(id);
            returnValue.put(method.getName(), new HashMap<String, Object>());
            returnValue.get(method.getName()).put("result", result);
            returnValue.get(method.getName()).put("executionTime", method.getExecutionTime());
        }
        return new ResponseEntity<>(returnValue, HttpStatus.OK);   
    }
}
