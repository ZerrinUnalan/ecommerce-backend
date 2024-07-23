package com.workintech.ecommerce.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credit_cards",schema = "ecommerce")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name = "card_no")
    private String card_no;

    @Column(name = "name")
    private String name;

    @Column(name = "expire_month")
    private Integer expireMonth;

    @Column(name = "expire_year")
    private Integer expireYear;

    @Column(name = "ccv")
    private Integer ccv;

    @Column(name = "secure")
    private boolean secure;
}