package com.rest.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "members")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Members {

    @Id
    @Column(name = "user_id", length = 50, nullable = false)
    private String userId;

    @Column(name = "pw", length = 100, nullable = false)
    private String password;

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Roles> roles;
}
