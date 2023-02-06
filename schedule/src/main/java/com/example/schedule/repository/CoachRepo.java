package com.example.schedule.repository;

import com.example.schedule.entity.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepo extends JpaRepository<CoachEntity, Long> {
    CoachEntity findByCoachName(String name);
}
