package com.demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/info")
public class InfoCtrl {

    @Value("${api-version}")
    private String API_VERSION;

    @GetMapping
    public ResponseEntity version() {
        return new ResponseEntity<>(Map.of("version", API_VERSION), HttpStatus.OK);
    }
}