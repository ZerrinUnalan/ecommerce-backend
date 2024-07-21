package com.workintech.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders",schema = "ecommerce")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "time")
    private Instant time;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_month")
    private String cardMonth;

    @Column(name = "card_year")
    private String cardYear;

    @Column(name = "card_cvv")
    private String cardCvv;

    @Column(name = "status")
    private String status;

    @Column(name = "address")
    private Address address;

    @Column(name = "user")
    private User user;

    @Column(name = "amount")
    private Double amount;
}