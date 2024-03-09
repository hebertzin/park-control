package com.parking.domain.spaces;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Spaces {
    @Id
    private String id;
    private String name;
    private String description;
    private String userId;
}
