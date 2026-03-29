package com.muhabet.userservice.repository;

import com.muhabet.userservice.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, String> {
    List<Favorite> findByUserId(String userId);
    boolean existsByUserIdAndWordId(String userId, String wordId);
}
