package io.github.rohergun.uptimemonitor.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || this.getClass() != object.getClass()) return false;

        User comparedUser = (User) object;
        return Objects.equals(this.getId(), comparedUser.getId())
                && Objects.equals(this.getEmail(), comparedUser.getEmail())
                && Objects.equals(this.getPassword(), comparedUser.getPassword())
                && Objects.equals(this.getName(), comparedUser.getName())
                && Objects.equals(this.getCreatedAt(), comparedUser.getCreatedAt())
                && Objects.equals(this.getRole(), comparedUser.getRole());
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getId(), this.getEmail(),
                this.getName(), this.getPassword(), this.getCreatedAt(), this.getRole());
    }


}
