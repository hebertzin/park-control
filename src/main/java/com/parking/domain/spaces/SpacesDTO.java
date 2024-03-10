package com.parking.domain.spaces;

import com.parking.domain.users.Users;

public record SpacesDTO(String title, String description, int price, String user) { }
