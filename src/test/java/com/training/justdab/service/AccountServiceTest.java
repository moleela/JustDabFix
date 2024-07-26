package com.training.justdab.service;

import com.training.justdab.model.Account;
import com.training.justdab.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    private AccountService accountService;

    private Account account;

    private Account account2;

    private Account account3;

    @BeforeEach
    void setUp() {
        accountService = new AccountServiceImpl(accountRepository);
        account = new Account();
        account.setId(1);
        account.setBalance(100);

        account2 = new Account();
        account2.setId(2);
        account2.setBalance(110);

        account3 = new Account();
        account3.setId(3);
        account3.setBalance(90);
    }

    @Test
    void getAccountByClientIdTest() {
        when(accountRepository.findByOwnerId(anyInt())).thenReturn(account);
        assertEquals(1, accountService.getAccountByClientId(anyInt()).getId());
        verify(accountRepository, times(1)).findByOwnerId(anyInt());
    }

    @Test
    void updateBalanceOfClientWithPositiveAmountTest() {
        when(accountRepository.findByOwnerId(anyInt())).thenReturn(account);
        when(accountRepository.save(any())).thenReturn(account2);
        assertEquals(110, accountService.updateBalanceOfClient(anyInt(), 10).getBalance());
        verify(accountRepository, times(1)).findByOwnerId(anyInt());
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    void updateBalanceOfClientWithNegativeAmountTest() {
        when(accountRepository.findByOwnerId(anyInt())).thenReturn(account);
        when(accountRepository.save(any())).thenReturn(account3);
        assertEquals(90, accountService.updateBalanceOfClient(anyInt(), -10).getBalance());
        verify(accountRepository, times(1)).findByOwnerId(anyInt());
        verify(accountRepository, times(1)).save(any(Account.class));
    }
}
