package com.example.schedule.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String birthDate;
    private List<String> skipped;

    /*public static Student toModel(StudentEntity entity){
        Student model = new Student();
        model.setId(entity.getId());
        model.setFullName(entity.getFullName());
        model.setPhoneNumber(entity.getPhoneNumber());
        model.setBirthDate(entity.getBirthDate());
        model.setSkipped(entity.getSkipped().stream().map(Student::toModel).collect(Collectors.toList()));
        return model;
    }
     */
}