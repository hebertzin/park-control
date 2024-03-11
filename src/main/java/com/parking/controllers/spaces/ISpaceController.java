package com.parking.controllers.spaces;

import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISpaceController {

    @Operation(summary = "Cadastra uma vaga de estacionamento no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vaga criada com seucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    ResponseEntity<Spaces> createSpaceController(SpacesDTO space) throws Exception;

    @Operation(summary = "Atualiza dados de uma vaga no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    ResponseEntity<Spaces> updateSpace(String id, SpacesDTO spaceDTO);

    @Operation(summary = "Apaga uma vaga do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "deletado com seucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    ResponseEntity<Void> deleteSpaceController(String id) throws Exception;

    @Operation(summary = "Pega dados de uma vaga especifica pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "consulta com seucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    ResponseEntity<Spaces> getSpaceByIdController(String id) throws Exception;

    @Operation(summary = "Pega todas as vagas de um usuário")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "consulta com seucesso"),
            @ApiResponse(responseCode = "400", description = "Se houve algum erro", content = @Content),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor", content = @Content)
    })
    ResponseEntity<List<Spaces>> getAllSpacesByUser(String id) throws Exception;
}
