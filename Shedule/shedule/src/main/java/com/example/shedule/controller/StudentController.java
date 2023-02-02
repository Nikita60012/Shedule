package com.example.shedule.controller;

import com.example.shedule.entity.StudentEntity;
import com.example.shedule.exceptions.ObjectAlreadyExistException;
import com.example.shedule.exceptions.ObjectNotFoundException;
import com.example.shedule.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student_controller")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity registration(@RequestBody StudentEntity student) {
        try {
            studentService.registration(student);
            return ResponseEntity.ok("Ученик добавлен");
        }catch (ObjectAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @GetMapping
    public ResponseEntity getOneStudent(@RequestParam Long id){
        try {
            return ResponseEntity.ok(studentService.getOne(id));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    /*
    @GetMapping
    public ResponseEntity getCoaches(){
        try {
            return  ResponseEntity.ok(coachService.getAll());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }

     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable Long id){
        try {
            return ResponseEntity.ok(studentService.deleteStudent(id));
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
}
