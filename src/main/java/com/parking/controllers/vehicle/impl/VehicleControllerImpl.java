package com.parking.controllers.vehicle.impl;
import com.parking.controllers.vehicle.IVehicleController;
import com.parking.domain.vehicle.Vehicle;
import com.parking.domain.vehicle.VehicleDTO;
import com.parking.services.vehicle.impl.VehicleServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleControllerImpl implements IVehicleController {
    private VehicleServiceImpl service;

    @Autowired
    public void VehicleController(VehicleServiceImpl service){
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vehicle> addVehicle(@Valid  @RequestBody VehicleDTO vehicleDTO) throws Exception{
            Vehicle vehicle = this.service.Create(vehicleDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
    }

    @GetMapping( value = "/all/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Vehicle>> getAllVehiclesByUserId(@PathVariable String userId) throws Exception{
            List<Vehicle> vehicles = this.service.findAllVehicles(userId);
            return  ResponseEntity.ok().body(vehicles);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Vehicle> listVehicleById(@PathVariable String id) throws Exception {
            Vehicle vehicle = this.service.listVehicleById(id);
            return ResponseEntity.ok().body(vehicle);
    }
}

