package com.workintech.ecommerce.service;

import com.workintech.ecommerce.converter.Converter;
import com.workintech.ecommerce.dto.LoginRequestDto;
import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.Role;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.repository.RoleRepository;
import com.workintech.ecommerce.repository.UserRepository;
import com.workintech.ecommerce.util.validations.GeneralValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(String name, String email, String password, String role) {
        Role userRole = new Role();
        String encodedPassword = passwordEncoder.encode(password);
        Optional<Role> optionalRole = roleRepository.findByRole(role);
        if (optionalRole.isPresent()) {
            userRole = optionalRole.get();
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(encodedPassword);
            user.setRole(userRole);
            userRepository.save(user);
            return user;

        } else {
            throw new CommerceException("Role mustn't be empty", HttpStatus.BAD_REQUEST);
        }
    }

    public UserResponseDto login(LoginRequestDto loginRequest) {
        GeneralValidation.checkEmptyOrNull(loginRequest.email(), "email ");
        GeneralValidation.checkEmptyOrNull(loginRequest.password(), "password ");
        Optional<User> optionalUser = userRepository.findUserByEmail(loginRequest.email());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            boolean arePasswordsMatches = passwordEncoder.matches(loginRequest.password(), user.getPassword());
            if (arePasswordsMatches) {
                return Converter.findUser(user);
            }
            throw new CommerceException("Invalid Credantials", HttpStatus.BAD_REQUEST);
        }
        throw new CommerceException("Invalid Credantials", HttpStatus.BAD_REQUEST);
    }

}