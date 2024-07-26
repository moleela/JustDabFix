package com.training.justdab.service;

import com.training.justdab.model.Client;
import com.training.justdab.model.Employee;
import com.training.justdab.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    private ClientService clientService;

    private List<Client> clients;

    private Client client;

    private Employee advisor;

    @BeforeEach
    void setUp() {
        clientService = new ClientServiceImpl(clientRepository);
        clients = new ArrayList<>();
        clients.add(new Client());
        clients.add(new Client());
        clients.add(new Client());
        advisor = new Employee();
        advisor.setId(3);
        client = new Client();
        client.setId(1);
        client.setAdvisor(advisor);
    }


    @Test
    void getAllClientsTest() {
        when(clientRepository.findAll()).thenReturn(clients);
        assertEquals(3, clientService.getAllClients().size());
        verify(clientRepository, times(1)).findAll();
    }

    @Test
    void getClientsByAdvisorTest() {
        when(clientRepository.findAllByAdvisorId(anyInt())).thenReturn(clients);
        assertEquals(3, clientService.getClientsByAdvisor(anyInt()).size());
        verify(clientRepository, times(1)).findAllByAdvisorId(anyInt());
    }

    @Test
    void getClientAdvisorByClientIdTest() {
        when(clientRepository.findById(1)).thenReturn(client);
        assertEquals(3, clientService.getClientAdvisorByClientId(1).getId());
        verify(clientRepository, times(1)).findById(1);
    }
}
