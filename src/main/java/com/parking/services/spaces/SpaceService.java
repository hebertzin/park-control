package com.parking.services.spaces;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.repository.spaces.SpacesRepository;
import com.parking.services.spaces.exception.SpaceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {

    private SpacesRepository repository;

    @Autowired
    public void SpaceService(SpacesRepository repository){
        this.repository = repository;
    }

    public Spaces Create(SpacesDTO space){
        Spaces newSpace = new Spaces(space);
        return this.repository.save(newSpace);
    }

    public Spaces getSpace(String id) throws SpaceException {
        Optional<Spaces> optionalSpace = this.repository.findById(id);
        return optionalSpace.orElseThrow(() -> new SpaceException());
    }

    public List<Spaces> getAllSpaceByUser(String id) throws EmptyResultDataAccessException {
        List<Spaces> listSapesByUser = this.repository.findAllByUser(id);
        return listSapesByUser;
    }

    public void deleteSpace(String id) throws  SpaceException {
        this.repository.findById(id).orElseThrow(() ->new SpaceException());
        this.repository.deleteById(id);
    }

    public Spaces updateSpace(String id, SpacesDTO spacesDTO){
        Spaces existingSpace = this.repository.findById(id)
                .orElseThrow(() -> new SpaceException());

        existingSpace.setTitle(spacesDTO.title());
        existingSpace.setDescription(spacesDTO.description());

        return  this.repository.save(existingSpace);
    }
}
