package com.parking.domain.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.vehicle.Vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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

    @JsonProperty("spaces")
    @DBRef
    private List<Spaces> spaces;

    @JsonProperty("vehicles")
    @DBRef
    private List<Vehicle> vehicles;

    public Users(UsersDTO user){
        this.name = user.name();
        this.email = user.email();
        this.password = user.password();
    }
}
