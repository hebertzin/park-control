package com.parking.domain.users;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
public class Users {
    @Id
    private  String id;
    private String name;
    private String email;
    private String password;

    public Users(UsersDTO user){
        this.name = user.name();
        this.email = user.email();
        this.password = user.password();
    }
}
