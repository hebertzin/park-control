package com.parking.controllers.spaces;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.services.spaces.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/spaces")

public class SpacesController {
    private SpaceService service;

    @Autowired
    public void SpacesController(SpaceService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Spaces> getSpaceByIdController(@PathVariable String id) throws EmptyResultDataAccessException{
        try {
            Spaces space = this.service.getSpace(id);
            return ResponseEntity.ok().body(space);
        }catch (EmptyResultDataAccessException e){
            return  ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Spaces> createSpaceController(@RequestBody SpacesDTO spaceDTO) throws  EmptyResultDataAccessException{
        try {
            Spaces space = this.service.Create(spaceDTO);
            return  ResponseEntity.ok().body(space);
        }catch (EmptyResultDataAccessException e){
            return  ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSpaceController(@PathVariable String id) throws  EmptyResultDataAccessException{
        try {
            this.service.deleteSpace(id);
            return ResponseEntity.ok().body("space was deleted successfully");
        }catch (EmptyResultDataAccessException e){
            return  ResponseEntity.notFound().build();
        }
    }
}
