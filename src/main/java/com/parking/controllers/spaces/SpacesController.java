package com.parking.controllers.spaces;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.services.spaces.SpaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spaces")
public class SpacesController {
    private SpaceService service;

    @GetMapping("/{id}")
    public Spaces getSpaceByIdController(@PathVariable String id){
        Spaces space = this.service.getSpace(id);
        return space;
    }

    @PostMapping
    public ResponseEntity<Spaces> createSpaceController(@RequestBody SpacesDTO spacesDTO){
        Spaces space = this.service.Create(spacesDTO);
        return  ResponseEntity.ok().body(space);
    }
}
