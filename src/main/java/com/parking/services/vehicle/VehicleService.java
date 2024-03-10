package com.parking.services.vehicle;

import com.parking.domain.vehicle.Vehicle;
import com.parking.domain.vehicle.VehicleDTO;
import com.parking.repository.vehicle.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleRepository repository;

    @Autowired
    public  VehicleService(VehicleRepository repository){
        this.repository = repository;
    }

    public Vehicle Create(VehicleDTO vehicleDTO){
        Vehicle vehicle = new Vehicle(vehicleDTO);
        return this.repository.save(vehicle);
    }

    public List<Vehicle> findAllVehicles(String userId){
        List<Vehicle> vehicle = this.repository.findAllByUserId(userId);
        return vehicle;
    }
}
