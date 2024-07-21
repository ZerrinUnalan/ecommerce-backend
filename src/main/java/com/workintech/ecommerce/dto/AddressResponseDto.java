package com.workintech.ecommerce.dto;

public record AddressResponseDto (long id,String name, String surname,String phone_number, String city, String district, String neighborhood, String address) {
}