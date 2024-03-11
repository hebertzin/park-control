package com.parking.controllers.users;

import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;

public interface IUserController {
    ResponseEntity<Users> createUser(UsersDTO user) throws Exception;

    ResponseEntity<Users> findById(String id) throws EmptyResultDataAccessException;

}
