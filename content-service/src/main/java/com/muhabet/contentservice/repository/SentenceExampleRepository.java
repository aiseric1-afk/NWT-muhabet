package com.muhabet.contentservice.repository;

import com.muhabet.contentservice.entity.SentenceExample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentenceExampleRepository extends JpaRepository<SentenceExample, String> {
    List<SentenceExample> findByWordId(String wordId);
    List<SentenceExample> findByPhraseId(String phraseId);
}
