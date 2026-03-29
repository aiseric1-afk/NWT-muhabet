package com.muhabet.contentservice.repository;

import com.muhabet.contentservice.entity.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, String> {
    List<Translation> findByWordId(String wordId);
    List<Translation> findByPhraseId(String phraseId);
    List<Translation> findByWordIdAndLanguage(String wordId, String language);
}
