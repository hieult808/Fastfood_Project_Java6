package com.poly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@Entity
@Table(name = "discountcodes")
public class DiscountCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_id")
    private int codeId;

    @Column(name = "code")
    private String code;

    @Column(name = "discount")
    private double discount;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    // Getters and Setters
}
