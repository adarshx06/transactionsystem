package com.example.transactionservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ping {

    private String serverTime;

    // public Ping(String serverTime) {
    //     this.serverTime = serverTime;
    // }
    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
    this.serverTime = serverTime;
    }
}

