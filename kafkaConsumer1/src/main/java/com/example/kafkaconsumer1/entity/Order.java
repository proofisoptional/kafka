package com.example.kafkaconsumer1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator="my_seq_gen")
    @SequenceGenerator(name="my_seq_gen", sequenceName="ORDERS_ID_SEQ", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "name_")
    private String productName;
    @Column(name = "bar_code_")
    private String barCode;
    @Column(name = "quantity_")
    private int quantity;
    @Column(name = "price_")
    private BigDecimal price;
}
