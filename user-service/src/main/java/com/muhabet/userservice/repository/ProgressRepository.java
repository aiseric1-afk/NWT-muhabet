package com.muhabet.userservice.repository;

import com.muhabet.userservice.entity.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgressRepository extends JpaRepository<Progress, String> {
    List<Progress> findByUserId(String userId);
    List<Progress> findByUserIdAndCompleted(String userId, Boolean completed);
}
