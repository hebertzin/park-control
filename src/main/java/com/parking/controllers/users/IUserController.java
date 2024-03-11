package com.parking.controllers.users;

import com.parking.domain.users.Users;
import com.parking.domain.users.UsersDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;

public interface IUserController {

    @Operation(summary = "Cadastra um usuário no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    ResponseEntity<Users> createUser(UsersDTO user) throws Exception;

    @Operation(summary = "Pega dados de um usuário no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Consulta com sucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    ResponseEntity<Users> findById(String id) throws EmptyResultDataAccessException;

}
