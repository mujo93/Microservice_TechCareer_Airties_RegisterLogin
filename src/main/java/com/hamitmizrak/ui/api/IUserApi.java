package com.hamitmizrak.ui.api;

import com.hamitmizrak.business.dto.UsernameDto;
import org.springframework.http.ResponseEntity;

public interface IUserApi {

    public ResponseEntity<?> getUserById(long id);
}
