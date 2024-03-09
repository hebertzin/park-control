package com.parking.controllers.users;

import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import com.parking.services.users.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UsersControllers {
    private UsersService service;
    public void CategoryController(UsersService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Users> insert(@RequestBody UsersDTO usersDTO){
        Users newUser = this.service.insert(usersDTO);
        return  ResponseEntity.ok().body(newUser);
    }
}
