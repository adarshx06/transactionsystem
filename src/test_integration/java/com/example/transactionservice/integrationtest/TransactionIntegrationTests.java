// package com.example.transactionservice.integrationtest;

// import com.example.transactionservice.controller.TransactionController;
// import com.example.transactionservice.model.*;
// import com.example.transactionservice.service.TransactionService;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;

// @SpringBootTest
// public class TransactionIntegrationTests {

//     @Autowired
//     private TransactionController transactionController;

//     @Autowired
//     private TransactionService transactionService;

//     @Test
//     public void testAuthorizeIntegration() {
//         // Arrange
//         AuthorizationRequest request = new AuthorizationRequest("user1", "789012", new Amount("50.00", "USD", DebitCredit.DEBIT));

//         // Act
//         ResponseEntity<AuthorizationResponse> responseEntity = transactionController.authorize("789012", request);

//         // Assert
//         assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//         AuthorizationResponse response = responseEntity.getBody();
//         assertNotNull(response);
//         // Add more assertions to verify the response content
//     }

//     @Test
//     public void testLoadIntegration() {
      
//         LoadRequest request = new LoadRequest("user1", "123456", new Amount("100.00", "USD", DebitCredit.CREDIT));

//         ResponseEntity<LoadResponse> responseEntity = transactionController.load("123456", request);

//         assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//         LoadResponse response = responseEntity.getBody();
//         assertNotNull(response);
       
//     }

//     @Test
//     public void testPingIntegration() {
//         // Act
//         ResponseEntity<Ping> responseEntity = transactionController.ping();

//         // Assert
//         assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//         Ping ping = responseEntity.getBody();
//         assertNotNull(ping);
//         //System.out.println(ping.getServerTime());
//         assertNotNull(ping.getServerTime());
//         // Add more assertions to verify the response content
//     }

//     @Test
//     public void testAuthorizeDeclinedIntegration() {
//         // Arrange
//         AuthorizationRequest request = new AuthorizationRequest("user1", "789012", new Amount("150.00", "USD", DebitCredit.DEBIT));

//         // Act
//         ResponseEntity<AuthorizationResponse> responseEntity = transactionController.authorize("789012", request);

//         // Assert
//         assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//         AuthorizationResponse response = responseEntity.getBody();
//         assertNotNull(response);
//         assertEquals(ResponseCode.DECLINED, response.getResponseCode());
//         // Add more assertions to verify the response content
//     }

// }