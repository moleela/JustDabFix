package com.training.justdab.service;

import com.training.justdab.model.Account;

public interface AccountService {

    Account updateBalanceOfClient(int clientId, double amount);

    Account getAccountByClientId(int clientId);
}
