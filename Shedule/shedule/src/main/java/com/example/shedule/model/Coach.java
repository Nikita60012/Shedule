package com.example.shedule.model;

import com.example.shedule.entity.CoachEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Coach {

    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    public static Coach toModel(CoachEntity entity){
        Coach model = new Coach();
        model.setId(entity.getId());
        model.setFullName(entity.getFullName());
        model.setPhoneNumber(entity.getPhoneNumber());
        model.setEmail(entity.getEmail());
       return model;
    }
}
