package com.parking.repository.vehicle;

import com.parking.domain.vehicle.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleRepository extends MongoRepository<Vehicle, String> { }
