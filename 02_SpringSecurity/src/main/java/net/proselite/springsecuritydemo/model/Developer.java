package net.proselite.springsecuritydemo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Developer {
    Long id;
    String firstName;
    String lastName;
}
