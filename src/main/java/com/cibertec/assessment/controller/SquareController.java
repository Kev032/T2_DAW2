package com.cibertec.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.assessment.model.Square;
import com.cibertec.assessment.service.SquareService;

@RestController
@RequestMapping("/squares")
public class SquareController {

    @Autowired
    private SquareService squareService;

    @GetMapping
    public ResponseEntity<List<Square>> listSquares() {
        List<Square> squares = squareService.list();
        return new ResponseEntity<>(squares, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Square> createSquare(@RequestBody Square s) {
    	
        System.out.println("Received Square: " + s);

        Square createdSquare = squareService.create(s);

        System.out.println("Stored Square: " + createdSquare);

        return new ResponseEntity<>(createdSquare, HttpStatus.CREATED);
    }
}