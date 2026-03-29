package com.muhabet.contentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sentence_examples")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SentenceExample {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "word_id")
    private Word word;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phrase_id")
    private Phrase phrase;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String sentence;

    @Column(columnDefinition = "TEXT")
    private String translation;

    // Referenca na audio fajl za rečenicu
    @Column(name = "audio_id")
    private String audioId;
}
