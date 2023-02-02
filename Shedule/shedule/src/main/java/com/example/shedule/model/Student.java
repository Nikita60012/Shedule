package com.example.shedule.model;

import com.example.shedule.entity.StudentEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String birthDate;
    //private List<String> skipped;

    public static Student toModel(StudentEntity entity){
        Student model = new Student();
        model.setId(entity.getId());
        model.setFullName(entity.getFullName());
        model.setPhoneNumber(entity.getPhoneNumber());
        model.setBirthDate(entity.getBirthDate());
        return model;
    }

}
