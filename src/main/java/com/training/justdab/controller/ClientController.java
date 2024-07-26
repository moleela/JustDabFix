package com.training.justdab.controller;

import com.training.justdab.model.Account;
import com.training.justdab.model.Employee;
import com.training.justdab.service.AccountService;
import com.training.justdab.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {

    private final AccountService accountService;

    private final ClientService clientService;

    public ClientController(AccountService accountService, ClientService clientService) {
        this.accountService = accountService;
        this.clientService = clientService;
    }

    // En tant que client, je veux pouvoir consulter mon compte bancaire afin de vérifier mon solde disponible

    @GetMapping("/clients/{id}/account")
    @ResponseBody
    public ResponseEntity<Account> getAccount(@PathVariable int id) {
        Account account = accountService.getAccountByClientId(id);
        return ResponseEntity.ok(account);
    }

    // En tant que client, je veux pouvoir déposer de l’argent liquide afin d’augmenter mon solde disponible
    // En tant que client, je veux pouvoir retirer de l’argent liquide afin d’effectuer des achats

    @PutMapping("/clients/{id}/account/balance")
    @ResponseBody
    public ResponseEntity<Account> updateBalance(@PathVariable int id,
                                                 @RequestParam double amountToAddOrWithdraw) {
        Account account = accountService.updateBalanceOfClient(id, amountToAddOrWithdraw);
        return ResponseEntity.ok(account);
    }

    // En tant que client, je veux avoir connaître le conseiller qui m’est attribué afin de pouvoir le contacter.
    @GetMapping("/clients/{id}/advisor")
    @ResponseBody
    public ResponseEntity<Employee> getAdvisor(@PathVariable int id) {
        Employee advisor = clientService.getClientAdvisorByClientId(id);
        return ResponseEntity.ok(advisor);
    }

}
