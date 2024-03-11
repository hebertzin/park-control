package com.parking.controllers.vehicle;
import com.parking.domain.vehicle.Vehicle;
import com.parking.domain.vehicle.VehicleDTO;
import com.parking.services.vehicle.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private VehicleService service;

    @Autowired
    public void VehicleController(VehicleService service){
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<Vehicle> addVehicle(@Valid  @RequestBody VehicleDTO vehicleDTO) throws Error{
        try {
            Vehicle vehicle = this.service.Create(vehicleDTO);
            return  ResponseEntity.status(HttpStatus.CREATED).body(vehicle);
        }catch (Error e){
           return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Vehicle>> addVehicle(@PathVariable String userId) throws Error{
        try {
            List<Vehicle> vehicles = this.service.findAllVehicles(userId);
            return  ResponseEntity.ok().body(vehicles);
        }catch (Error e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Vehicle> listVehicleById(@PathVariable String id) throws EmptyResultDataAccessException {
        try {
            Vehicle vehicle = this.service.listVehicleById(id);
            return ResponseEntity.ok().body(vehicle);
        }catch (EmptyResultDataAccessException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

