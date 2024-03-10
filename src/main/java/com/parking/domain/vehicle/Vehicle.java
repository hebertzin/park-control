package com.parking.domain.vehicle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "vehicles")
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {
    @Id
    private String id;

    private String brand;

    private String model;

    private String plate;

    private String userId;

    public Vehicle(VehicleDTO vehicleDTO){
        this.brand = vehicleDTO.brand();
        this.model = vehicleDTO.model();
        this.plate = vehicleDTO.plate();
        this.userId = vehicleDTO.userId();
    }
}
