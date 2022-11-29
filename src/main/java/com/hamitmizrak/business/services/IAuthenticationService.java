package com.hamitmizrak.business.services;

import com.hamitmizrak.business.dto.LoginResponse;
import com.hamitmizrak.business.dto.UserDto;

public interface IAuthenticationService {

    LoginResponse loginReturnJwt(UserDto userDto);
}
