package com.training.justdab.repository;

import com.training.justdab.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findById(int id);

    List<Client> findAll();

    List<Client> findAllByAdvisorId(int advisorId);
}
