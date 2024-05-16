package com.example.transactionservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadRequest {
  private String userId;
  private String messageId;
  private Amount transactionAmount;

  public String getUserId() {
      return userId;
  }

  public void setUserId(String userId) {
      this.userId = userId;
  }

  public String getMessageId() {
      return messageId;
  }

  public void setMessageId(String messageId) {
      this.messageId = messageId;
  }

  public Amount getTransactionAmount() {
      return transactionAmount;
  }

  public void setTransactionAmount(Amount transactionAmount) {
      this.transactionAmount = transactionAmount;
  }
}