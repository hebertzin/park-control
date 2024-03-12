package com.parking.services.spaces;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;


import java.util.List;

public interface ISpaceService {
    Spaces createAdsSpace(SpacesDTO space);

    Spaces getSpaceAds(String id) throws Exception;

    List<Spaces> getAllAdsSpaceByUser(String userId) throws Exception;

    void deleteSpaceAds(String id) throws Exception;

    Spaces updateSpaceAds(String id, SpacesDTO space);
}
