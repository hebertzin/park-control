package com.parking.controllers.vehicle;
import com.parking.domain.vehicle.Vehicle;
import com.parking.domain.vehicle.VehicleDTO;
import com.parking.services.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<Vehicle> addVehicle(@RequestBody VehicleDTO vehicleDTO) throws Error{
        try {
            Vehicle vehicle = this.service.Create(vehicleDTO);
            return  ResponseEntity.ok().body(vehicle);
        }catch (Error e){
           return  ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<Vehicle>> addVehicle(@PathVariable String userId) throws Error{
        try {
            List<Vehicle> vehicles = this.service.findAllVehicles(userId);
            return  ResponseEntity.ok().body(vehicles);
        }catch (Error e){
            return  ResponseEntity.badRequest().build();
        }
    }
}

