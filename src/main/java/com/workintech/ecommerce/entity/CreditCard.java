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

    private String card_no;
    private String name;
    private Integer expireMonth;
    private Integer expireYear;
    private Integer ccv;
}