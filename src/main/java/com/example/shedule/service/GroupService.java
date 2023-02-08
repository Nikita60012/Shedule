package com.example.shedule.service;

import com.example.shedule.entity.GroupEntity;
import com.example.shedule.entity.StudentEntity;
import com.example.shedule.exceptions.ObjectNotFoundException;
import com.example.shedule.model.Group;
import com.example.shedule.model.Student;
import com.example.shedule.repository.GroupRepo;
import com.example.shedule.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    //need to fix
    public String add(Long groupId, Long studentId){
        StudentEntity student = studentRepo.findById(studentId).get();
        GroupEntity group = groupRepo.findById(groupId).get();
        group.getStudentsList().add(student);
        student.setGroup(group);
        studentRepo.save(student);
        return "Ученик добавлен в группу";
    }
    public String remove(Long groupId, Long studentId){
        GroupEntity group = groupRepo.findById(groupId).get();
        StudentEntity student = studentRepo.findById(studentId).get();

        return "Ученик исключён из группы";
    }
    public Group readOne(Long id) throws ObjectNotFoundException {
        GroupEntity group = groupRepo.findById(id).get();
        if(group == null){
            throw new ObjectNotFoundException("Записи с такой группой не существует");
        }
        return Group.toModel(group);
    }
    public List<Group> readAll() throws ObjectNotFoundException {
        List<Group> groupList = new ArrayList<>();
        for (GroupEntity group : groupRepo.findAll()){
            groupList.add(Group.toModel(group));
        }
        if(groupList == null){
            throw new ObjectNotFoundException("Ученики отсутствуют");
        }
        return groupList;
    }
    public Set<Student> readStudents(Long id){
        Set<Student> students = new HashSet<>();
        GroupEntity group = groupRepo.findById(id).get();
        for(StudentEntity student : group.getStudentsList()) {
            students.add(Student.toModel(student));
        }
        return students;
    }
}
