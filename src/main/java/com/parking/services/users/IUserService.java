package com.parking.services.users;

import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;

public interface IUserService {
    Users CreateUser(UsersDTO user);

    Users getUser(String id) throws Exception;
}
