package com.hamitmizrak.ui.api.impl;

import com.hamitmizrak.business.dto.UsernameDto;
import com.hamitmizrak.business.services.IUserServices;
import com.hamitmizrak.ui.api.IUserApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("gateway/users")
public class UserApiImpl implements IUserApi {

    private final IUserServices userServices;
    private static final String PATH = "gateway/posts";

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(userServices.getUserById(id), HttpStatus.OK);
    }
}
