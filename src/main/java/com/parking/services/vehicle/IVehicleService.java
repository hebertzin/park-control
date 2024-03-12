package com.parking.services.vehicle;

import com.parking.domain.vehicle.Vehicle;
import com.parking.domain.vehicle.VehicleDTO;

import java.util.List;

public interface IVehicleService {
    Vehicle Create(VehicleDTO vehicleDTO) throws Exception;

    List<Vehicle> findAllVehicles(String userId) throws Exception;

    Vehicle listVehicleById(String id);
}
