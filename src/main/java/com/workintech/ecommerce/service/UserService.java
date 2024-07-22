package com.workintech.ecommerce.service;

import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.User;

import java.util.List;

public interface UserService {
    void findUserByEmail(String email);
    User findUserByID(long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto saveUser(User user);
    User deleteUser(long id);
}