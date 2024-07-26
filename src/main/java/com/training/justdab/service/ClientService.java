package com.training.justdab.service;

import com.training.justdab.model.Client;
import com.training.justdab.model.Employee;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();

    List<Client> getClientsByAdvisor(int advisorId);

    Employee getClientAdvisorByClientId(int clientId);
}
