package com.workintech.ecommerce.controller;

import com.workintech.ecommerce.converter.Converter;
import com.workintech.ecommerce.dto.LoginRequestDto;
import com.workintech.ecommerce.dto.UserRequestDto;
import com.workintech.ecommerce.dto.LoginResponseDto;
import com.workintech.ecommerce.dto.UserResponseDto;
import com.workintech.ecommerce.entity.User;
import com.workintech.ecommerce.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup/")
    public UserResponseDto register(@RequestBody UserRequestDto userRequest){
        User user=authenticationService
                .signup(userRequest.name(), userRequest.email(),
                        userRequest.password(), userRequest.role());

        return Converter.findUser(user);
    }

    @PostMapping("/login")
    public UserResponseDto login(@RequestBody LoginRequestDto loginRequest){
        return authenticationService.login(loginRequest);

    }
}