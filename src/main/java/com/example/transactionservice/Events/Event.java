package com.example.transactionservice.Events;


import java.time.ZonedDateTime;
import com.example.transactionservice.models.*;


public class Event {

    private String messageId;
    private String userId;
    private Amount amount;
    private ResponseCode responseCode;
    private ZonedDateTime timestamp;

    public Event() {
    }

    public Event(String messageId, String userId, Amount amount, ResponseCode responseCode, ZonedDateTime timestamp) {
        this.messageId = messageId;
        this.userId = userId;
        this.amount = amount;
        this.responseCode = responseCode;
        this.timestamp = timestamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
    
    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

   
    @Override
    public String toString() {
        return "Event{" +
                "userId='" + userId + '\'' +
                ", messageId='" + messageId + '\'' +
                ", amount=" + amount +
                ", responseCode=" + responseCode +
                ", timestamp=" + timestamp +
                '}';
    }
}