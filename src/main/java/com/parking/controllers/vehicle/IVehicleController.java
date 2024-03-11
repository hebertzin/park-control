package com.parking.controllers.vehicle;

import com.parking.domain.vehicle.Vehicle;
import com.parking.domain.vehicle.VehicleDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleController {

   ResponseEntity<Vehicle> addVehicle(VehicleDTO vehicle) throws Exception;

   ResponseEntity<Vehicle> listVehicleById(String id) throws Exception;

   ResponseEntity<List<Vehicle>> getAllVehiclesByUserId(String id) throws Exception;
}
