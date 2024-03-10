package com.parking.domain.spaces;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "spaces")
@Getter
@Setter
@NoArgsConstructor
public class Spaces {
    @Id
    private String id;

    private String title;
    private String description;

   @JsonProperty("parking_price")
    private int price;

   @JsonProperty("user_id")
   private String user;

    public Spaces(SpacesDTO spaces){
        this.title = spaces.title();
        this.description = spaces.description();
        this.price = spaces.price();
        this.user = spaces.user();
    }
}
