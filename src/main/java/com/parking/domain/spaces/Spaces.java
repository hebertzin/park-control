package com.parking.domain.spaces;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("user_id")
    private String userId;
}
