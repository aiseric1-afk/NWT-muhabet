package com.muhabet.exerciseservice.repository;

import com.muhabet.exerciseservice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, String> {
    List<Question> findByExerciseId(String exerciseId);
}
