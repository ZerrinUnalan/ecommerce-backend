package com.workintech.ecommerce.mapper;

import com.workintech.ecommerce.dto.AddressResponseDto;
import com.workintech.ecommerce.entity.Address;

public class AddressMapper {

    public static AddressResponseDto toDto(Address address) {
        if (address == null) {
            return null;
        }
        return new AddressResponseDto(address.getId(), address.getName(), address.getSurname(),
                address.getPhone(), address.getCity(), address.getDistrict(), address.getNeighborhood(),
                address.getAddress());
    }
}
