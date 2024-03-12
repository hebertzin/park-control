package com.parking.services.spaces.impl;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.repository.spaces.SpacesRepository;
import com.parking.repository.users.UsersRepository;
import com.parking.services.spaces.ISpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SpaceServiceImpl implements ISpaceService {

    private SpacesRepository repository;
    private UsersRepository usersRepository;

    @Autowired
    public void SpaceService(
            SpacesRepository repository,
            UsersRepository userRepository
    ){
        this.repository = repository;
        this.usersRepository = userRepository;
    }

    public Spaces createAdsSpace(SpacesDTO space){
        Spaces newSpace = new Spaces(space);
        return this.repository.save(newSpace);
    }

    public Spaces getSpaceAds(String id){
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException();
        }

        Optional<Spaces> optionalSpace = this.repository.findById(id);

       return  optionalSpace.orElseThrow(() -> new EmptyResultDataAccessException(1));
    }

    public List<Spaces> getAllAdsSpaceByUser(String id){
        this.usersRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));

        return  this.repository.findAllByUser(id);
    }

    public void deleteSpaceAds(String id){
        if(id == null || id.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.repository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1));
        this.repository.deleteById(id);
    }

    public Spaces updateSpaceAds(String id, SpacesDTO spacesDTO){
        if(id == null || id.isEmpty()){
           throw new IllegalArgumentException();
        }
        Spaces existingSpace = this.repository.findById(id)
                .orElseThrow(() -> new EmptyResultDataAccessException(1));

        existingSpace.setTitle(spacesDTO.title());
        existingSpace.setDescription(spacesDTO.description());

        return  this.repository.save(existingSpace);
    }
}
