package com.muhabet.exerciseservice.repository;

import com.muhabet.exerciseservice.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, String> {
    List<UserAnswer> findByUserId(String userId);
    List<UserAnswer> findByUserIdAndIsCorrect(String userId, Boolean isCorrect);
    List<UserAnswer> findByQuestionId(String questionId);
    long countByUserIdAndIsCorrect(String userId, Boolean isCorrect);
}
