package com.example.shedule.controller;

import com.example.shedule.exceptions.ObjectAlreadyExistException;
import com.example.shedule.exceptions.ObjectNotFoundException;
import com.example.shedule.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.shedule.entity.CoachEntity;

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
        }catch (ObjectAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @GetMapping
    public ResponseEntity getOneCoach(@RequestParam Long id){
        try {
            return ResponseEntity.ok(coachService.getOne(id));
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
    @DeleteMapping
    public ResponseEntity deleteCoach(@PathVariable Long id){
        try {
            return ResponseEntity.ok(coachService.deleteCoach(id));
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
}
