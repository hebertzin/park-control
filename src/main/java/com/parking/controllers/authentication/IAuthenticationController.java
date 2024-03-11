package com.parking.controllers.authentication;

import com.parking.domain.auth.LoginRequest;

public interface IAuthenticationController {
    void  authenticate(LoginRequest request);
}
