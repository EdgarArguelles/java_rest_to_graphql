package com.demo.controllers;

import com.demo.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GameCtrl {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity findAll() {
        return new ResponseEntity<>(gameService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return new ResponseEntity<>(gameService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/stores")
    public ResponseEntity getGames(@PathVariable Long id) {
        return new ResponseEntity<>(gameService.findById(id).getStores(), HttpStatus.OK);
    }
}