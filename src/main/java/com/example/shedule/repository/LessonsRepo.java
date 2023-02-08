package com.example.shedule.repository;

import com.example.shedule.entity.LessonsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonsRepo extends JpaRepository<LessonsEntity, Long> {
}