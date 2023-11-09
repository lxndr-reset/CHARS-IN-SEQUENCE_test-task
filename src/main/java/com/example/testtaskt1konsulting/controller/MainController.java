package com.example.testtaskt1konsulting.controller;

import com.example.testtaskt1konsulting.service.SequenceService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    private final SequenceService sequenceService;

    @Autowired
    public MainController(SequenceService sequenceService) {
        this.sequenceService = sequenceService;
    }

    @PostMapping("/getAllSequenceElementsCount")
    public ResponseEntity<List<Map.Entry<String, Long>>> getCountOfEachSymbolInLine(@RequestBody String string) {
        if (string == null || string.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Map.Entry<String, Long>> res = sequenceService.getCountOfEachSymbol(string);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
