package com.parking.repository.spaces;

import com.parking.domain.spaces.Spaces;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpacesRepository extends MongoRepository<Spaces, String> {}
