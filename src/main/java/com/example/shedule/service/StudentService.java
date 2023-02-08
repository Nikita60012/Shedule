package com.example.shedule.service;

import com.example.shedule.entity.CoachEntity;
import com.example.shedule.entity.StudentEntity;
import com.example.shedule.exceptions.ObjectAlreadyExistException;
import com.example.shedule.exceptions.ObjectNotFoundException;
import com.example.shedule.model.Coach;
import com.example.shedule.model.Student;
import com.example.shedule.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public String edit(Long id, StudentEntity student){
        StudentEntity editingStudent = studentRepo.findById(id).get();
        if(student.getFullName() != null){ editingStudent.setFullName(student.getFullName());}
        if(student.getPhoneNumber() != null){ editingStudent.setPhoneNumber(student.getPhoneNumber());}
        if(student.getBirthDate() != null){ editingStudent.setBirthDate(student.getBirthDate());}
        studentRepo.save(editingStudent);
        return "Данные ученика изменены";
    }
    public Student readOne(Long id) throws ObjectNotFoundException {
        StudentEntity student = studentRepo.findById(id).get();
        if(student == null){
            throw new ObjectNotFoundException("Записи с таким учеником не существует");
        }
        return Student.toModel(student);
    }
    public List<Student> readAll() throws ObjectNotFoundException {
        List<Student> studentList = new ArrayList<>();
        for(StudentEntity student : studentRepo.findAll()){
            studentList.add(Student.toModel(student));
        }
        if(studentList == null){
            throw new ObjectNotFoundException("Ученики отсутствуют");
        }
        return studentList;
    }
    public String deleteStudent(Long id){
        studentRepo.deleteById(id);
        return "Ученик удалён";
    }
}
