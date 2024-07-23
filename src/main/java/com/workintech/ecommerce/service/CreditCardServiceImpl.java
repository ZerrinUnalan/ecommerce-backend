package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.CreditCard;
import com.workintech.ecommerce.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService{
    private final CreditCardRepository cardRepository;
    @Autowired
    public CreditCardServiceImpl(CreditCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public List<CreditCard> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public CreditCard getCardById(long id) {
        return cardRepository.getCreditCardById(id);
    }

    @Override
    public CreditCard saveCard(CreditCard card) {
        return cardRepository.save(card);
    }
}