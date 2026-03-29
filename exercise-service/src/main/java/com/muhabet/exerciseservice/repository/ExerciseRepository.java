package com.muhabet.exerciseservice.repository;

import com.muhabet.exerciseservice.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, String> {
    List<Exercise> findByLessonId(String lessonId);
    List<Exercise> findByType(String type);
    List<Exercise> findByLessonIdAndType(String lessonId, String type);
}
