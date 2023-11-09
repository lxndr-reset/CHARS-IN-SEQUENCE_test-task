package com.example.testtaskt1konsulting.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SequenceService {


    public List<Map.Entry<String, Long>> getCountOfEachSymbol(String string) {
        LinkedHashMap<String, Long> map = string.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()));

        List<Map.Entry<String, Long>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        return list;
    }
}


