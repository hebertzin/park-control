package com.parking.controllers.users.impl;
import com.parking.controllers.users.IUserController;
import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import com.parking.services.users.impl.UsersServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UsersControllersImpl implements IUserController {
    private UsersServiceImpl service;

    @Autowired
    public void UsersControllersImpl(UsersServiceImpl service){
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> createUser(@Valid @RequestBody UsersDTO usersDTO){
            Users newUser = this.service.CreateUser(usersDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> findById(@PathVariable String id) throws Exception{
            Users user = this.service.getUser(id);
            return  ResponseEntity.ok().body(user);
    }
}
