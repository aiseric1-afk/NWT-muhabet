package com.muhabet.exerciseservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "exercises")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // Cross-service referenca na content-service
    @Column(name = "lesson_id", nullable = false)
    private String lessonId;

    // Tip vježbe: MULTIPLE_CHOICE, FILL_IN_BLANK, MATCHING, FLASHCARD
    @Column(nullable = false)
    private String type;

    @Column
    private String title;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions;
}
