package com.example.shedule.controller;

import com.example.shedule.entity.GroupEntity;
import com.example.shedule.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
