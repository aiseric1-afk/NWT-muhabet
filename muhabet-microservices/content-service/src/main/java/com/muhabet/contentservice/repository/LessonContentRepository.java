package com.muhabet.contentservice.repository;

import com.muhabet.contentservice.entity.LessonContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonContentRepository extends JpaRepository<LessonContent, String> {
    List<LessonContent> findByLessonIdOrderByOrderInLesson(String lessonId);
}
