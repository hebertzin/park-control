package com.parking.repository.spaces;

import com.parking.domain.spaces.Spaces;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpacesRepository extends MongoRepository<Spaces, String> {
}
