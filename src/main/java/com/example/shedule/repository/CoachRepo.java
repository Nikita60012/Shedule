package com.example.shedule.repository;

import com.example.shedule.entity.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepo extends JpaRepository<CoachEntity, Long> {
    //CoachEntity findByCoachName(String name);
}
