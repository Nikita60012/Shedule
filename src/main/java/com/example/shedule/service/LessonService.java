package com.example.shedule.service;

import com.example.shedule.entity.CoachEntity;
import com.example.shedule.entity.GroupEntity;
import com.example.shedule.entity.LessonsEntity;
import com.example.shedule.exceptions.ObjectNotFoundException;
import com.example.shedule.repository.GroupRepo;
import com.example.shedule.repository.LessonsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService  {

    @Autowired
    private GroupRepo groupRepo;
    @Autowired
    private LessonsRepo lessonsRepo;
    public String create(Long id, LessonsEntity lesson){
        GroupEntity group = groupRepo.findById(id).get();
        lesson.setGroupName(group.getName());
        lessonsRepo.save(lesson);
        return "Урок создан";
    }
    public String edit(Long id, LessonsEntity lesson){
        LessonsEntity editingLesson = lessonsRepo.findById(id).get();
        if(lesson.getGroupName() != null){ editingLesson.setGroupName(lesson.getGroupName());}
        if(lesson.getDate() != null){ editingLesson.setDate(lesson.getDate());}
        if(lesson.getTime() != null){ editingLesson.setTime(lesson.getTime());}
        lessonsRepo.save(editingLesson);
        return "Данные урока изменены";
    }
    public List<LessonsEntity> readAll() throws ObjectNotFoundException {
        List<LessonsEntity> lessonsList;
        lessonsList = lessonsRepo.findAll();
        if(lessonsList == null){
            throw new ObjectNotFoundException("Ученики отсутствуют");
        }
        return lessonsList;
    }
    public String delete(Long id){
        lessonsRepo.deleteById(id);
        return "Урок отменён";
    }
}
