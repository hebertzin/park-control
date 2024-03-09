package com.parking.controllers.spaces;
import com.parking.domain.spaces.Spaces;
import com.parking.domain.spaces.SpacesDTO;
import com.parking.services.spaces.SpaceService;
import com.parking.services.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spaces")
public class SpacesController {
    private SpaceService service;

    @Autowired
    public void SpacesController(SpaceService service){
        this.service = service;
    }

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
