package com.parking.services.spaces;

import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.services.spaces.exception.SpaceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

public interface ISpaceService {
    Spaces createAdsSpace(SpacesDTO space);

    Spaces getSpaceAds(String id) throws SpaceNotFoundException;

    List<Spaces> getAllAdsSpaceByUser(String userId) throws EmptyResultDataAccessException;

    void deleteSpaceAds(String id) throws Exception;

    Spaces updateSpaceAds(String id, SpacesDTO space);
}
