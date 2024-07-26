package com.training.justdab.controller;

import com.training.justdab.model.Client;
import com.training.justdab.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdvisorController.class)
public class AdvisorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;


    private List<Client> clients;

    @BeforeEach
    void setUp() {
        clients = new ArrayList<>();
        clients.add(new Client());
        clients.add(new Client());
        clients.add(new Client());
    }

    @Test
    void getAllClientsOfSpecifiedAdvisor() throws Exception {
        when(clientService.getClientsByAdvisor(3)).thenReturn(clients);

        mockMvc.perform(get("/advisor/3/clients"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllClients() throws Exception {
        when(clientService.getAllClients()).thenReturn(clients);

        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk());
    }
}

