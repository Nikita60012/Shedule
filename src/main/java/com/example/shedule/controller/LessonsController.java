package com.example.shedule.controller;

import com.example.shedule.entity.CoachEntity;
import com.example.shedule.entity.LessonsEntity;
import com.example.shedule.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("lessons_controller")
public class LessonsController {
    @Autowired
    private LessonService lessonService;
    @PostMapping
    public ResponseEntity createLesson(@RequestParam Long id, @RequestBody LessonsEntity lesson){
        try{
            return ResponseEntity.ok(lessonService.create(id, lesson));
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @GetMapping
    public ResponseEntity readAll(){
        try{
            return ResponseEntity.ok(lessonService.readAll());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        try{
            return ResponseEntity.ok(lessonService.delete(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @PutMapping
    public ResponseEntity editLesson(@RequestParam Long id, @RequestBody LessonsEntity lesson) {
        try {
            return ResponseEntity.ok(lessonService.edit(id, lesson));
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
}
