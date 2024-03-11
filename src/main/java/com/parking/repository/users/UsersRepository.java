package com.parking.repository.users;
import com.parking.domain.users.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<Users, String> {
    Optional<Users> findByIdUsernameOrEmail(String username, String email);
}