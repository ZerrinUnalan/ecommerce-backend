package com.workintech.ecommerce.service;

import com.workintech.ecommerce.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address findAddressByID(long id);
    List<Address> getAllAddress();
    String saveAddress(Address address);
}

// package com.workintech.ecommerce.service;
//
//import com.workintech.ecommerce.dto.AddressResponseDto;
//import com.workintech.ecommerce.entity.Address;
//import com.workintech.ecommerce.mapper.AddressMapper;
//import com.workintech.ecommerce.repository.AddressRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AddressService {
//
//    @Autowired
//    private AddressRepository addressRepository;
//
//    public AddressResponseDto getAddressById(Long id) {
//        Address address = addressRepository.findById(id).orElseThrow(() -> new RuntimeException("Address not found"));
//        return AddressMapper.INSTANCE.addressToAddressResponseDto(address);
//    }
//}