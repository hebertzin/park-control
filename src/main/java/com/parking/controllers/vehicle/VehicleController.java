package com.parking.controllers.vehicle;
import com.parking.domain.vehicle.Vehicle;
import com.parking.domain.vehicle.VehicleDTO;
import com.parking.services.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            Vehicle vehicle = new Vehicle(vehicleDTO);
            return  ResponseEntity.ok().body(vehicle);
        }catch (Error e){
           return  ResponseEntity.badRequest().build();
        }
    }
}

