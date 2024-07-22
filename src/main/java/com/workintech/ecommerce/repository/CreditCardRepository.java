package com.workintech.ecommerce.repository;

import com.workintech.ecommerce.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
    @Query(value = "SELECT * FROM ecommerce.credit_card AS c WHERE c.id = :credit_cardId",nativeQuery = true)
    CreditCard getCreditCardById(long credit_cardId);
}