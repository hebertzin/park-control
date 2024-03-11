package com.parking.services.spaces;

import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.services.spaces.exception.SpaceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface ISpaceService {
    Spaces Create(SpacesDTO space);

    Spaces getSpace(String id) throws SpaceNotFoundException;

    List<Spaces> getAllSpaceByUser(String userId) throws EmptyResultDataAccessException;

    void deleteSpace(String id) throws Exception;

    Spaces updateSpace(String id, SpacesDTO space);
}
