package com.workintech.ecommerce.mapper;

import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserResponseDto toDto(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    public static List<UserResponseDto> toDtoList(List<User> users) {
        if (users == null) {
            return null;
        }
        return users.stream().map(UserMapper::toDto).collect(Collectors.toList());
    }
}
