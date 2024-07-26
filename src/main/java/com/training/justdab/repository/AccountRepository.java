package com.training.justdab.repository;

import com.training.justdab.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findByOwnerId(int id);

    Account save(Account account);
}
