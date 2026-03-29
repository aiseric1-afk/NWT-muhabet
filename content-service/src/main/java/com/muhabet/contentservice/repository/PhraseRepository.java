package com.muhabet.contentservice.repository;

import com.muhabet.contentservice.entity.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhraseRepository extends JpaRepository<Phrase, String> {
    List<Phrase> findByTextContainingIgnoreCase(String text);
    List<Phrase> findByLanguage(String language);
}
