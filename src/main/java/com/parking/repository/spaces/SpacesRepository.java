package com.parking.repository.spaces;

import com.parking.domain.spaces.Spaces;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpacesRepository extends MongoRepository<Spaces, String> {
    List<Spaces> findAllByUser(String userId);
}