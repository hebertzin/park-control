package com.parking.controllers.spaces.impl;
import com.parking.controllers.spaces.ISpaceController;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.services.spaces.impl.SpaceServiceImpl;
import com.parking.services.spaces.exception.SpaceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/ads/spaces")
public class SpacesControllerImpl implements ISpaceController {
    private SpaceServiceImpl service;

    @Autowired
    public void SpacesController(SpaceServiceImpl service){
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Spaces> createSpaceController(@Valid @RequestBody SpacesDTO spaceDTO) throws Exception{
             Spaces space = this.service.Create(spaceDTO);
             return  ResponseEntity.status(HttpStatus.CREATED).body(space);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Spaces> updateSpace(@PathVariable String id, @Valid @RequestBody SpacesDTO spaceDTO) {
        try {
             Spaces spaces = this.service.updateSpace(id, spaceDTO);
             return ResponseEntity.ok().body(spaces);
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteSpaceController(@PathVariable String id) throws Exception{
        try {
            this.service.deleteSpace(id);
            return ResponseEntity.ok().build();
        }catch (SpaceNotFoundException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Spaces> getSpaceByIdController(@PathVariable String id) throws Exception{
        try {
            Spaces space = this.service.getSpace(id);
            return ResponseEntity.ok().body(space);
        }catch (SpaceNotFoundException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping(value = "/all/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Spaces>> getAllSpacesByUser(@PathVariable String id) throws Exception{
        try {
            List<Spaces> spaces = this.service.getAllSpaceByUser(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(spaces);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
