package com.parking.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.parking.domain.users.Users;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${spring.api.security.token.secret}")
    private String secret;

    public String generateToken(Users user){
      try {

          Algorithm algorithm = Algorithm.HMAC256(secret);

          String token = JWT.create()
                  .withIssuer("user-authentication")
                  .withSubject(user.getEmail())
                  .sign(algorithm);

          return  token;

      }catch (JWTCreationException exception){
          throw  new RuntimeException("Error creating token");
      }
    }

    public String validateToken(String token){
        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.require(algorithm)
                    .withIssuer("user-authentication")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException exception){
            return "";
        }
    }
}
