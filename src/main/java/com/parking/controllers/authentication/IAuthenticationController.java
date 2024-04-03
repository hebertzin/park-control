package com.parking.controllers.authentication;

import com.parking.domain.auth.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface IAuthenticationController {
    ResponseEntity authenticate(LoginRequest request);
}
