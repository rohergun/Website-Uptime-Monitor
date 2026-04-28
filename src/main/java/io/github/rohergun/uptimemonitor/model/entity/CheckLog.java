package io.github.rohergun.uptimemonitor.model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "checklogs")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CheckLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int httpStatus;

    private boolean success;

    private int responseTime;

    private String errorMessage;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Todo FK monitoredSite_id

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
