package com.training.justdab.controller;

import com.training.justdab.model.Client;
import com.training.justdab.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvisorController {

    private final ClientService clientService;

    public AdvisorController(ClientService clientService) {
        this.clientService = clientService;
    }

    //En tant que conseiller, je veux pouvoir consulter la liste de mes clients afin de pouvoir les contacter.

    @GetMapping("/advisor/{id}/clients")
    @ResponseBody
    public ResponseEntity<List<Client>> getAllClientsOfSpecifiedAdvisor(@PathVariable int id) {
        List<Client> clients = clientService.getClientsByAdvisor(id);
        return ResponseEntity.ok(clients);
    }

    //En tant que conseiller, je veux pouvoir consulter la liste de l’ensemble des clients possédant un compte afin de pouvoir leur envoyer une offre promotionnelle.

    @GetMapping("/clients")
    @ResponseBody
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

}
