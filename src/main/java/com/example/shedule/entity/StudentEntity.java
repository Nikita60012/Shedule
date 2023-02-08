package com.example.shedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String birthDate;
    @ManyToOne@JoinColumn(name = "group_id")
    private GroupEntity group;
}
