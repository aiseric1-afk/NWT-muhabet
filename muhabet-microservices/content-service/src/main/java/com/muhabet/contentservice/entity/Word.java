package com.muhabet.contentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "words")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    @Builder.Default
    private String language = "bs";

    @Column(name = "part_of_speech")
    private String partOfSpeech;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Translation> translations;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SentenceExample> sentenceExamples;

    @OneToMany(mappedBy = "word", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AudioFile> audioFiles;
}
