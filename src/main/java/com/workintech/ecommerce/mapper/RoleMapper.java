package com.workintech.ecommerce.mapper;

import com.workintech.ecommerce.dto.RoleResponseDto;
import com.workintech.ecommerce.entity.Role;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper {

    public static RoleResponseDto toDto(Role role) {
        if (role == null) {
            return null;
        }
        return new RoleResponseDto(role.getId(), role.getRole());
    }

    public static List<RoleResponseDto> toDtoList(List<Role> roles) {
        if (roles == null) {
            return null;
        }
        return roles.stream().map(RoleMapper::toDto).collect(Collectors.toList());
    }
}
