package com.parking.services.vehicle.impl;

import com.parking.domain.vehicle.Vehicle;
import com.parking.domain.vehicle.VehicleDTO;
import com.parking.repository.vehicle.VehicleRepository;
import com.parking.services.vehicle.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements IVehicleService {
    private VehicleRepository repository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository repository){
        this.repository = repository;
    }

    public Vehicle Create(VehicleDTO vehicleDTO) throws Exception{
        Vehicle vehicle = new Vehicle(vehicleDTO);
        return this.repository.save(vehicle);
    }

    public List<Vehicle> findAllVehicles(String userId){
        List<Vehicle> vehicle = this.repository.findAllByUserId(userId);
        return vehicle;
    }
    public Vehicle listVehicleById(String id) throws EmptyResultDataAccessException{
        Optional<Vehicle> optionalVehicle = this.repository.findById(id);
        return optionalVehicle.orElseThrow(() -> new EmptyResultDataAccessException(1));
    }
}
