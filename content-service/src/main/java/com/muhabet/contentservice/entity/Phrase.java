package com.muhabet.contentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "phrases")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phrase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    @Builder.Default
    private String language = "bs";

    @OneToMany(mappedBy = "phrase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Translation> translations;

    @OneToMany(mappedBy = "phrase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SentenceExample> sentenceExamples;

    @OneToMany(mappedBy = "phrase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AudioFile> audioFiles;
}
