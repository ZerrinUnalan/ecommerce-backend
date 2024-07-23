package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.entity.CreditCard;
import com.workintech.ecommerce.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CreditCardController {
    private CreditCardService cardService;

    @Autowired
    public CreditCardController(CreditCardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/")
    public CreditCard saveCard(@RequestBody CreditCard card){
        return cardService.saveCard(card);
    }

    @GetMapping("/")
    public List<CreditCard> getAllCards(){
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public CreditCard getCardById(@PathVariable long id){
        return cardService.getCardById(id);
    }
}