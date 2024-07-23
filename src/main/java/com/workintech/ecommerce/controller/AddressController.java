package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.converter.Converter;
import com.workintech.ecommerce.dto.AddressResponseDto;
import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.service.AddressService;
import com.workintech.ecommerce.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public AddressResponseDto getAddressById(@PathVariable long id){
        return Converter.findAddress(addressService.findAddressByID(id));
    }

    @PutMapping("/{id}")
    public AddressResponseDto updateAddress(@RequestBody Address address, @PathVariable long id){
        return null;
    }

}