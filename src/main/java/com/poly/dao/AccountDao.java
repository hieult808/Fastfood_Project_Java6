package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer> {

	Account findByUsername(String username);

	Account findById(int accountId);

}
