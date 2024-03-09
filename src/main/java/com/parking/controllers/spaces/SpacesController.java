package com.parking.controllers.spaces;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpacesController {
    @GetMapping("/spaces")
    public  String  getAllSpaces(){
        return "get all spaces";
    }
}
