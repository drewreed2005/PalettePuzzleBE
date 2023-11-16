package com.nighthawk.spring_portfolio.mvc.palette;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nighthawk.spring_portfolio.mvc.palette.Palette;
import com.nighthawk.spring_portfolio.mvc.palette.SortRequest;

@RestController
@RequestMapping("/api/palette") // Sets the path to our dijkstra algorithm
public class PaletteApiController {
    private JSONObject body; //last run result
    private HttpStatus status; //last run status
    String last_run = null; //last run day of month

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Object> findShortestPath(@RequestBody SortRequest request) {
        s

        return new ResponseEntity<>(shortestPath, HttpStatus.OK);
    }
}
