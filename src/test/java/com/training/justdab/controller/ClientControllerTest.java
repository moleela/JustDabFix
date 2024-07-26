package com.training.justdab.controller;

import com.training.justdab.model.Account;
import com.training.justdab.model.Employee;
import com.training.justdab.service.AccountService;
import com.training.justdab.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private ClientService clientService;

    private Account account;

    private Account account2;

    private Account account3;

    private Employee advisor;

    @BeforeEach
    void setUp() {
        account = new Account();
        account.setId(1);
        account.setBalance(100);

        account2 = new Account();
        account2.setId(2);
        account2.setBalance(110);

        account3 = new Account();
        account3.setId(3);
        account3.setBalance(90);

        advisor = new Employee();
        advisor.setId(3);
    }

    @Test
    void getAccountTest() throws Exception {
        when(accountService.getAccountByClientId(1)).thenReturn(account);

        mockMvc.perform(get("/clients/1/account"))
                .andExpect(status().isOk());
    }

    @Test
    void updateBalanceWithPositiveAmountTest() throws Exception {
        int amount = 10;
        when(accountService.updateBalanceOfClient(1, amount)).thenReturn(account2);

        mockMvc.perform(put("/clients/1/account/balance")
                        .queryParam("amountToAddOrWithdraw", String.valueOf(amount)))
                .andExpect(status().isOk());
    }

    @Test
    void updateBalanceWithNegativeAmountTest() throws Exception {
        int amount = -10;
        when(accountService.updateBalanceOfClient(1, amount)).thenReturn(account3);

        mockMvc.perform(put("/clients/1/account/balance")
                        .queryParam("amountToAddOrWithdraw", String.valueOf(amount)))
                .andExpect(status().isOk());
    }

    @Test
    void getAdvisorTest() throws Exception {
        when(clientService.getClientAdvisorByClientId(1)).thenReturn(advisor);

        mockMvc.perform(get("/clients/1/advisor"))
                .andExpect(status().isOk());
    }

}
