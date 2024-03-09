package com.parking.services.users;

import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import com.parking.repository.users.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
  private UsersRepository repository;

  public void CreateUserService(UsersRepository repository){
    this.repository = repository;
  }

  public Users insert(UsersDTO user){
      Users newUser = new Users(user);
      this.repository.save(newUser);
      return  newUser;
  };
}
