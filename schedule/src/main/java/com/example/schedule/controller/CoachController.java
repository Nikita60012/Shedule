package com.example.schedule.controller;

import com.example.schedule.exceptions.CoachAlreadyExistException;
import com.example.schedule.exceptions.CoachNotFoundException;
import com.example.schedule.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.schedule.entity.CoachEntity;

@RestController
@RequestMapping("/coach_controller")
public class CoachController {
    @Autowired
    private CoachService coachService;
    @PostMapping
    public ResponseEntity registration(@RequestBody CoachEntity coach) {
        try {
            coachService.registration(coach);
            return ResponseEntity.ok("Тренер добавлен");
        }catch (CoachAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @GetMapping
    public ResponseEntity getOneCoach(@RequestParam Long id){
        try {
            return ResponseEntity.ok(coachService.getOne(id));
        }catch (CoachNotFoundException e){
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
    public ResponseEntity deleteCoach(@PathVariable Long id){
        try {
            return ResponseEntity.ok(coachService.deleteCoach(id));
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
}