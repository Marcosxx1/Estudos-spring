package com.rest.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "users")
 @NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @Column(name = "username", length = 50, nullable = false)
    private String username;

    @Column(name = "password", length = 50, nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Authority> authorities;
}
