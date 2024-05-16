package com.example.transactionservice.controllertest;

import com.example.transactionservice.controllers.TransactionController;
import com.example.transactionservice.models.*;
import com.example.transactionservice.services.TransactionService;
import com.example.transactionservice.util.DateTimeProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TransactionController.class)
public class TransactionControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private DateTimeProvider dateTimeProvider;

    // Unit Test for the ping method
    @Test
    public void testPing() throws Exception {
        when(dateTimeProvider.getCurrentDateTime()).thenReturn("Ping Working fine!");

        mockMvc.perform(get("/ping")).andExpect(status().isOk()).andExpect(jsonPath("$.serverTime").value("Ping Working fine!"));
    }

    // Unit Test for the authorize approved method
    @Test
    public void testAuthorize_Approved() throws Exception {
        AuthorizationRequest request = new AuthorizationRequest("customer1", "10101", new Amount("50.0", "USD", DebitCredit.DEBIT));
        AuthorizationResponse response = new AuthorizationResponse("customer1", "10101", ResponseCode.APPROVED, new Amount("50.0", "USD", DebitCredit.CREDIT));

        when(transactionService.authorize(any(String.class), any(AuthorizationRequest.class))).thenReturn(response);

        mockMvc.perform(put("/authorization/789012")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\": \"customer1\", \"messageId\": \"10101\", \"transactionAmount\": {\"amount\": \"50.00\", \"currency\": \"USD\", \"debitOrCredit\": \"DEBIT\"}}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId").value("customer1"))
                .andExpect(jsonPath("$.messageId").value("10101"))
                .andExpect(jsonPath("$.responseCode").value("APPROVED"))
                .andExpect(jsonPath("$.balance.amount").value("50.0"))
                .andExpect(jsonPath("$.balance.currency").value("USD"))
                .andExpect(jsonPath("$.balance.debitOrCredit").value("CREDIT"));
    }

    // Unit Test for the authorize declined method
    @Test
    public void testAuthorize_Declined() throws Exception {
        AuthorizationRequest request = new AuthorizationRequest("customer2", "10102", new Amount("150.0", "USD", DebitCredit.DEBIT));
        AuthorizationResponse response = new AuthorizationResponse("customer2", "10102", ResponseCode.DECLINED, new Amount("50.0", "USD", DebitCredit.CREDIT));

        when(transactionService.authorize(any(String.class), any(AuthorizationRequest.class))).thenReturn(response);

        mockMvc.perform(put("/authorization/789012")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\": \"customer2\", \"messageId\": \"10102\", \"transactionAmount\": {\"amount\": \"150.0\", \"currency\": \"USD\", \"debitOrCredit\": \"DEBIT\"}}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId").value("customer2"))
                .andExpect(jsonPath("$.messageId").value("10102"))
                .andExpect(jsonPath("$.responseCode").value("DECLINED"))
                .andExpect(jsonPath("$.balance.amount").value("50.0"))
                .andExpect(jsonPath("$.balance.currency").value("USD"))
                .andExpect(jsonPath("$.balance.debitOrCredit").value("CREDIT"));
    }

    // Unit Test for the load method
    @Test
    public void testLoad() throws Exception {
        LoadRequest request = new LoadRequest("customer3", "12345", new Amount("1000.0", "USD", DebitCredit.CREDIT));
        LoadResponse response = new LoadResponse("customer3", "12345", new Amount("1000.0", "USD", DebitCredit.CREDIT));

        when(transactionService.load(any(String.class), any(LoadRequest.class))).thenReturn(response);

        mockMvc.perform(put("/load/12345")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"userId\": \"customer2\", \"messageId\": \"12345\", \"transactionAmount\": {\"amount\": \"1000.0\", \"currency\": \"USD\", \"debitOrCredit\": \"CREDIT\"}}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.userId").value("customer3"))
                .andExpect(jsonPath("$.messageId").value("12345"))
                .andExpect(jsonPath("$.balance.amount").value("1000.0"))
                .andExpect(jsonPath("$.balance.currency").value("USD"))
                .andExpect(jsonPath("$.balance.debitOrCredit").value("CREDIT"));
    }
}