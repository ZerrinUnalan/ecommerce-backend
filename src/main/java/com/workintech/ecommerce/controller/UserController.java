package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.entity.Address;
import com.workintech.ecommerce.service.AddressService;
import com.workintech.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private AddressService addressService;

    @Autowired
    public UserController(UserService userService, AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/address")
    public String saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
}