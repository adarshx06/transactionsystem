package com.example.transactionservice.services;


import com.example.transactionservice.Events.*;
import com.example.transactionservice.models.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    private final Map<String, Double> userBalances = new HashMap<>();

    private final List<Event> eventStore = new ArrayList<>();
    
    public AuthorizationResponse authorize(String messageId, AuthorizationRequest request) {
        String userId = request.getUserId();
        Amount transactionAmount = request.getTransactionAmount();
        double amount = Double.parseDouble(transactionAmount.getAmount());

        // Check if the user has enough balance
        double currentBalance = userBalances.getOrDefault(userId, 0.0);
        boolean authorized = currentBalance >= amount;

        //Check the authorization status
        ResponseCode responseCode = authorized ? ResponseCode.APPROVED : ResponseCode.DECLINED;

        if (authorized) {
            currentBalance -= amount;
            userBalances.put(userId, currentBalance);
        }


        Amount balance = new Amount(String.valueOf(currentBalance), transactionAmount.getCurrency(), DebitCredit.CREDIT);

        Event event = new Event();
        event.setUserId(userId);
        event.setMessageId(messageId);
        event.setAmount(balance);
        //event.setEventType(EventType.AUTHORIZATION);
        event.setResponseCode(responseCode);
        event.setTimestamp(ZonedDateTime.now());
        eventStore.add(event);

        logger.info("Authorization event: {}", event);

        return new AuthorizationResponse(userId, messageId, responseCode, balance);
    }

    public LoadResponse load(String messageId, LoadRequest request) {

        String userId = request.getUserId();
        Amount transactionAmount = request.getTransactionAmount();
        double amount = Double.parseDouble(transactionAmount.getAmount());

        // Load the amount to the user's balance
        double currentBalance = userBalances.getOrDefault(userId, 0.0);
        currentBalance += amount;
        userBalances.put(userId, currentBalance);

        Amount balance = new Amount(String.valueOf(currentBalance), transactionAmount.getCurrency(), DebitCredit.CREDIT);

        Event event = new Event();
        event.setUserId(userId);
        event.setMessageId(messageId);
        event.setAmount(balance);
        //event.setAmount(amount);

        //event.setEventType(EventType.AUTHORIZATION);
        //event.setResponseCode(responseCode);
        event.setTimestamp(ZonedDateTime.now());
        eventStore.add(event);

        logger.info("Load event: {}", event);
        return new LoadResponse(userId, messageId, balance);
    }
}