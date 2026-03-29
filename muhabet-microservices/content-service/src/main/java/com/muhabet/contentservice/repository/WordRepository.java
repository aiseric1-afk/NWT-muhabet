package com.muhabet.contentservice.repository;

import com.muhabet.contentservice.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {
    List<Word> findByTextContainingIgnoreCase(String text);
    List<Word> findByLanguage(String language);
    List<Word> findByPartOfSpeech(String partOfSpeech);
}
