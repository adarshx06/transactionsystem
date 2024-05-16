package com.example.transactionservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Amount {
  private String amount;
  private String currency;
  private DebitCredit debitOrCredit;

  public String getAmount() {
      return amount;
  }

  public void setAmount(String amount) {
      this.amount = amount;
  }

  public String getCurrency() {
      return currency;
  }

  public void setCurrency(String currency) {
      this.currency = currency;
  }

  public DebitCredit getDebitOrCredit() {
      return debitOrCredit;
  }

  public void setDebitOrCredit(DebitCredit debitOrCredit) {
      this.debitOrCredit = debitOrCredit;
  }
}