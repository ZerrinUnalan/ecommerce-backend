package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.CreditCard;
import java.util.List;

public interface CreditCardService {
    List<CreditCard> getAllCards();
    CreditCard getCardById(long id);
    CreditCard saveCard(CreditCard card);
}