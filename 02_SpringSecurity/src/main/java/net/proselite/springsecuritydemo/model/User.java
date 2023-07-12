package net.proselite.springsecuritydemo.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Generated;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "email")
    String email;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "password")
    String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    Status status;
}
