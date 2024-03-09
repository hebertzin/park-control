package com.parking.services.users;
import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import com.parking.repository.users.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsersService {
  private UsersRepository repository;

  @Autowired
  public void UsersService(UsersRepository repository){
    this.repository = repository;
  }

  public Users CreateUser(UsersDTO user){
      Users newUser = new Users(user);
      return  this.repository.save(newUser);
  };

  public Users getUser(String id){
      Optional<Users> optionalUsers = this.repository.findById(id);
      return  optionalUsers.orElseThrow(() -> new EmptyResultDataAccessException(1));
  }
}
