package com.example.unitech.repository;

import com.example.unitech.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByIsActiveTrue();
}

