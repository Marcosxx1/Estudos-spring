package com.rest.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authorities", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username", "authority"})
})

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authority", length = 50, nullable = false)
    private String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username", nullable = false)
    private User user;

}
