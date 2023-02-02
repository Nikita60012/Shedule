package com.example.shedule.service;

import com.example.shedule.entity.StudentEntity;
import com.example.shedule.exceptions.ObjectAlreadyExistException;
import com.example.shedule.exceptions.ObjectNotFoundException;
import com.example.shedule.model.Student;
import com.example.shedule.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    public StudentEntity registration(StudentEntity student) throws ObjectAlreadyExistException {
        // if(coachRepo.findByCoachName(coach.getFullName()) != null){
        //     throw new CoachAlreadyExistException("Такой тренер уже существует");
        // }
        return studentRepo.save(student);
    }
    public Student getOne(Long id) throws ObjectNotFoundException {
        StudentEntity student = studentRepo.findById(id).get();
        if(student == null){
            throw new ObjectNotFoundException("Записи с таким учеником                                           не существует");
        }
        return Student.toModel(student);
    }
    /*public Coach getAll() throws CoachNotFoundException {
        List<Coach> coachList = coachRepo.findAll().stream().map(Coach::toModel).collect(Collectors.toList());
        if(coachList == null){
            throw new CoachNotFoundException("Тренеры отсутствуют");
        }
        return coachRepo.findAll();
    }

     */
    public String deleteStudent(Long id){
        studentRepo.deleteById(id);
        return "Ученик удалён";
    }
}
