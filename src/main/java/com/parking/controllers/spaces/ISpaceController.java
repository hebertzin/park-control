package com.parking.controllers.spaces;

import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISpaceController {
    ResponseEntity<Spaces> createSpaceController(SpacesDTO space) throws Exception;

    ResponseEntity<Spaces> updateSpace(String id, SpacesDTO spaceDTO);

    ResponseEntity<Void> deleteSpaceController(String id) throws Exception;

    ResponseEntity<Spaces> getSpaceByIdController(String id) throws Exception;

    ResponseEntity<List<Spaces>> getAllSpacesByUser(String id) throws Exception;
}
