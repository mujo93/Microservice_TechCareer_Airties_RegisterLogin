package com.hamitmizrak.business.services.impl;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hamitmizrak.business.dto.LoginResponse;
import com.hamitmizrak.business.dto.UserDto;
import com.hamitmizrak.business.services.IAuthenticationService;
import com.hamitmizrak.security.UserPrincipal;
import com.hamitmizrak.security.jwt.IJwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthenticationServiceImpl implements IAuthenticationService {

    //injection
    @Autowired
    private  AuthenticationManager authenticationManager;
    @Autowired
    private  IJwtProvider iJwtProvider;

    @Override
    public LoginResponse loginReturnJwt(UserDto userDto){
        //Authentication ==> UserDto username ve password vermek
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));

        // UserPrincipal
        UserPrincipal  userPrincipal= (UserPrincipal) authentication.getPrincipal();

        //IJwtProvider
        return LoginResponse.builder()
                .JWT(iJwtProvider.generateToken(userPrincipal))
                .userId(userPrincipal.getId()).build();
    }
}