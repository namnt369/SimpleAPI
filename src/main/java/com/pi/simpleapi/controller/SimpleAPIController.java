package com.pi.simpleapi.controller;

import com.pi.simpleapi.entity.Breed;
import com.pi.simpleapi.service.SimpleAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/breeds")
public class SimpleAPIController {
    @Autowired
    SimpleAPIService simpleAPIService;

    @RequestMapping("list/all")
    public ResponseEntity<Breed> getAll() throws IOException {
        Object obj = simpleAPIService.getData();
        Breed breed = new Breed();
        breed.setMessage(obj);
        breed.setStatus("success");
        return ResponseEntity.ok(breed);
    }
}
