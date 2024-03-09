package com.parking.services.spaces;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.repository.spaces.SpacesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpaceService {

    private SpacesRepository repository;

    public Spaces Create(SpacesDTO space){
        Spaces newSpace = new Spaces();
        return  this.repository.save(newSpace);
    }

    public Spaces getSpace(String id){
        Optional<Spaces> optionalSpace = this.repository.findById(id);
        return  optionalSpace.orElse(null);
    }
}
