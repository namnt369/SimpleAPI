package com.pi.simpleapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

@Service
public class SimpleAPIService {
    private ObjectMapper objectMapper;

    @Autowired
    public SimpleAPIService(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    public SortedMap<String, List<String>> getData() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/data.json");

        if (inputStream == null)
            throw new IOException("check input file");

        SortedMap<String, List<String>> jsonObj = objectMapper.readValue(inputStream, SortedMap.class);

        return jsonObj;
    }

}
