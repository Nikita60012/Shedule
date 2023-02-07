package com.example.shedule.controller;

import com.example.shedule.entity.GroupEntity;
import com.example.shedule.exceptions.ObjectNotFoundException;
import com.example.shedule.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group_controller")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity create(@RequestBody GroupEntity group){
        try{
            groupService.create(group);
            return ResponseEntity.ok("Группа создана");
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @GetMapping
    public ResponseEntity getAllGroups(){
        try {
            return  ResponseEntity.ok(groupService.readAll());
        }catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity getOneGroup(@PathVariable Long id){
        try {
            return ResponseEntity.ok(groupService.readOne(id));
        }catch (ObjectNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body("Ошибка!");
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam Long id){
        try{
            return ResponseEntity.ok(groupService.delete(id));
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @PostMapping("/{groupId}/{studentId}")
    public ResponseEntity studentAdd(@PathVariable Long groupId, @PathVariable Long studentId){
        try{
            return ResponseEntity.ok(groupService.add(groupId, studentId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка!");
        }
    }
    @DeleteMapping("/{groupId}/{studentId}")
    public ResponseEntity removeStudent(@PathVariable Long groupId, @PathVariable Long studentId){
        try{
            return ResponseEntity.ok(groupService.remove(groupId, studentId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка!");
        }
    }
}
