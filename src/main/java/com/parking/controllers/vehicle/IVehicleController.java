package com.parking.controllers.vehicle;

import com.parking.domain.vehicle.Vehicle;
import com.parking.domain.vehicle.VehicleDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IVehicleController {

   @Operation(summary = "Adiciona um veiculo no sistema")
   @ApiResponses(value = {
           @ApiResponse(responseCode = "201", description = "Veiculo adicionado com sucesso"),
           @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
           @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
   })
   ResponseEntity<Vehicle> addVehicle(VehicleDTO vehicle) throws Exception;

   @Operation(summary = "Pega dados de um veiculo no sistema")
   @ApiResponses(value = {
           @ApiResponse(responseCode = "200", description = "Consulta com sucesso"),
           @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
           @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
   })
   ResponseEntity<Vehicle> listVehicleById(String id) throws Exception;

   @Operation(summary = "APaga veiculo do sistema")
   @ApiResponses(value = {
           @ApiResponse(responseCode = "200", description = "deletado com sucesso"),
           @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
           @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
   })
   ResponseEntity<List<Vehicle>> getAllVehiclesByUserId(String id) throws Exception;
}
