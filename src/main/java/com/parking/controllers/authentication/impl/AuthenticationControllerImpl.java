package com.parking.controllers.authentication.impl;

import com.parking.controllers.authentication.IAuthenticationController;
import com.parking.domain.auth.LoginRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
public class AuthenticationControllerImpl implements IAuthenticationController {
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void authenticate(@RequestBody LoginRequest login){
    }
}
