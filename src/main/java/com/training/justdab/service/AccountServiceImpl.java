package com.training.justdab.service;

import com.training.justdab.model.Account;
import com.training.justdab.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account getAccountByClientId(int clientId) {
        return accountRepository.findByOwnerId(clientId);
    }

    @Override
    public Account updateBalanceOfClient(int clientId, double amount) {
        Account account = getAccountByClientId(clientId);
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }
}
