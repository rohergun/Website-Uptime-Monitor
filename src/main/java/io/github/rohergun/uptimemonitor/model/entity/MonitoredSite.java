package io.github.rohergun.uptimemonitor.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sites")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MonitoredSite {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    private int checkIntervalsMinute;

    private boolean isActive;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Todo FK user_id

    @PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
}
