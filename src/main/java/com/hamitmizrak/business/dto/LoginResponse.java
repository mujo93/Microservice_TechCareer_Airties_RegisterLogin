package com.hamitmizrak.business.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Builder
public class LoginResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("access_token")
    private String JWT;
    @JsonProperty("user_id")
    private Long userId;


    public String getJWT() {
        return JWT;
    }


    public Long getUserId() {
        return userId;
    }




}
