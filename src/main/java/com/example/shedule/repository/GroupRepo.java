package com.example.shedule.repository;

import com.example.shedule.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<GroupEntity, Long> {
}
