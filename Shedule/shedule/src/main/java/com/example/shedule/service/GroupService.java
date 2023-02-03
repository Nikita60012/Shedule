package com.example.shedule.service;

import com.example.shedule.entity.GroupEntity;
import com.example.shedule.entity.StudentEntity;
import com.example.shedule.repository.GroupRepo;
import com.example.shedule.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class GroupService {
    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private StudentRepo studentRepo;


    public GroupEntity create(GroupEntity group){
        return groupRepo.save(group);
    }
    public String delete(Long id){
        groupRepo.deleteById(id);
        return "Группа распущена";
    }
    public String add(Long groupId, Long studentId){
        StudentEntity student = studentRepo.findById(studentId).get();
        GroupEntity group = groupRepo.findById(groupId).get();
        Set<String> list = new HashSet<>();
        list = group.getStudentsList();
        String name = student.getFullName();
        list.add(name);
        group.setStudentsList(list);
        groupRepo.save(group);
        return student.getFullName();
    }
}
