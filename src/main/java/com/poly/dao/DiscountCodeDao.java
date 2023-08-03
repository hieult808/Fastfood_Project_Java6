package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.entity.DiscountCode;

public interface DiscountCodeDao extends JpaRepository<DiscountCode, Integer> {

}
