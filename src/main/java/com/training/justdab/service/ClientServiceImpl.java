package com.training.justdab.service;

import com.training.justdab.model.Client;
import com.training.justdab.model.Employee;
import com.training.justdab.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public List<Client> getClientsByAdvisor(int advisorId) {
        return clientRepository.findAllByAdvisorId(advisorId);
    }

    @Override
    public Employee getClientAdvisorByClientId(int clientId) {
        return clientRepository.findById(clientId).getAdvisor();
    }

}
