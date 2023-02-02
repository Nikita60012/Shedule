package com.example.shedule.service;

import com.example.shedule.entity.GroupEntity;
import com.example.shedule.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;
    public GroupEntity create(GroupEntity group){
        return groupRepo.save(group);
    }
}
