package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Account;
import com.poly.entity.Order;

public interface OrdersDao extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.account = :account AND o.totalPrice IS NULL")
    Order findUncompletedOrder(Account account);
}
