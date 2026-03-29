package com.muhabet.userservice.repository;

import com.muhabet.userservice.entity.AiText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AiTextRepository extends JpaRepository<AiText, String> {
    List<AiText> findByUserIdOrderByCreatedAtDesc(String userId);
}
