package com.muhabet.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "progress")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // ID lekcije iz content-service (cross-service referenca)
    @Column(name = "lesson_id", nullable = false)
    private String lessonId;

    @Column(nullable = false)
    @Builder.Default
    private Boolean completed = false;

    @Column
    @Builder.Default
    private Float accuracy = 0.0f;
}
