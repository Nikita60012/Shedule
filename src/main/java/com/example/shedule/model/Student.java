package com.example.shedule.model;

import com.example.shedule.entity.GroupEntity;
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
    private Long groupId;
    //private List<String> skipped;

    public static Student toModel(StudentEntity entity){
        Student model = new Student();
        model.setId(entity.getId());
        model.setFullName(entity.getFullName());
        model.setPhoneNumber(entity.getPhoneNumber());
        model.setBirthDate(entity.getBirthDate());
        model.setGroupId(entity.getGroup().getId());
        return model;
    }

}
