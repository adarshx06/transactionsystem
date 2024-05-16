package com.example.transactionservice.controllers;

import com.example.transactionservice.models.*;
import com.example.transactionservice.services.TransactionService;
import com.example.transactionservice.util.DateTimeProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private DateTimeProvider dateTimeProvider;

    @GetMapping("/ping")
    public ResponseEntity<Ping> ping() {
        Ping ping = new Ping(dateTimeProvider.getCurrentDateTime());
        return ResponseEntity.ok(ping);
    }

    @PutMapping("/authorization/{messageId}")
    public ResponseEntity<AuthorizationResponse> authorize(@PathVariable String messageId, @RequestBody AuthorizationRequest request) {
        AuthorizationResponse response = transactionService.authorize(messageId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/load/{messageId}")
    public ResponseEntity<LoadResponse> load(@PathVariable String messageId, @RequestBody LoadRequest request) {
        LoadResponse response = transactionService.load(messageId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}