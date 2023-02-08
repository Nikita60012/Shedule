package com.example.shedule.model;

import com.example.shedule.entity.CoachEntity;
import com.example.shedule.entity.GroupEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Group {

    private Long id;
    private String name;
    private Integer size;
    private Integer minAge;
    private Integer maxAge;
    public static Group toModel(GroupEntity entity){
        Group model = new Group();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setSize(entity.getSize());
        model.setMinAge(entity.getMinAge());
        model.setMaxAge(entity.getMaxAge());
        return model;
    }
}
