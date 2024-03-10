package com.parking.services.spaces;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.repository.spaces.SpacesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpaceService {

    private SpacesRepository repository;

    @Autowired
    public SpaceService(SpacesRepository repository){
        this.repository = repository;
    }

    public Spaces Create(SpacesDTO space) throws EmptyResultDataAccessException{
        Spaces newSpace = new Spaces(space);
        return this.repository.save(newSpace);
    }

    public Spaces getSpace(String id) throws EmptyResultDataAccessException {
        Optional<Spaces> optionalSpace = this.repository.findById(id);
        return optionalSpace.orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public void deleteSpace(String id) throws  EmptyResultDataAccessException {
        getSpace(id);
        this.repository.deleteById(id);
    }
}
