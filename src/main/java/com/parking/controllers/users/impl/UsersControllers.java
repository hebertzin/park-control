package com.parking.controllers.users.impl;
import com.parking.controllers.users.IUserController;
import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import com.parking.services.users.UsersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UsersControllers implements IUserController {
    private UsersService service;

    @Autowired
    public void UsersControllers(UsersService service){
        this.service = service;
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Users> createUser(@Valid @RequestBody UsersDTO usersDTO) throws Exception{
        try {
            Users newUser = this.service.CreateUser(usersDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }catch (Error e){
            return  ResponseEntity.notFound().build();
        }

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> findById(@PathVariable String id) throws EmptyResultDataAccessException{
        try {
            Users users = this.service.getUser(id);
            return  ResponseEntity.ok().body(users);
        }catch (EmptyResultDataAccessException e){
            return  ResponseEntity.notFound().build();
        }
    }
}
