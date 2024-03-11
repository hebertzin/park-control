package com.parking.services.spaces.exception;

public class SpaceNotFoundException extends  Exception{

    public SpaceNotFoundException(){
        super();
    }
    public SpaceNotFoundException(String message){
        super(message);
    }
}
