package com.parking.controllers.users;
import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import com.parking.services.users.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UsersControllers {
    private UsersService service;

    @Autowired
    public void UsersControllers(UsersService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Users> createUser(@Valid  @RequestBody UsersDTO usersDTO){
        try {
            Users newUser = this.service.CreateUser(usersDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }catch (Error e){
            return  ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable String id) throws EmptyResultDataAccessException{
        try {
            Users users = this.service.getUser(id);
            return  ResponseEntity.ok().body(users);
        }catch (EmptyResultDataAccessException e){
            return  ResponseEntity.notFound().build();
        }

    }
}
