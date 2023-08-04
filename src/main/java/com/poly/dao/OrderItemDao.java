package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.OrderItem;

public interface OrderItemDao extends JpaRepository<OrderItem, Integer> {

}
