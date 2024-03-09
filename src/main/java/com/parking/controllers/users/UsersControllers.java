package com.parking.controllers.users;
import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import com.parking.services.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UsersControllers {
    private UsersService service;

    @Autowired
    public void UsersController(UsersService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Users> insert(@RequestBody UsersDTO usersDTO){
        Users newUser = this.service.CreateUser(usersDTO);
        return  ResponseEntity.ok().body(newUser);
    }

    @GetMapping("/{id}")
    public Users findById(@PathVariable String id){
        Users users = this.service.getUser(id);
        return  users;
    }
}
