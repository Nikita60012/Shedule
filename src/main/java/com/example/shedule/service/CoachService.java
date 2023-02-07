package com.example.shedule.service;

import com.example.shedule.entity.CoachEntity;
import com.example.shedule.exceptions.ObjectAlreadyExistException;
import com.example.shedule.exceptions.ObjectNotFoundException;
import com.example.shedule.model.Coach;
import com.example.shedule.repository.CoachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoachService {
    @Autowired
    private CoachRepo coachRepo;
    public CoachEntity registration(CoachEntity coach) throws ObjectAlreadyExistException {
        /*if(coachRepo.findByCoachName(coach.getFullName()) != null){
            throw new ObjectAlreadyExistException("Такой тренер уже существует");
        }

         */
        return coachRepo.save(coach);
    }
    public String edit(Long id, CoachEntity coach){
        CoachEntity editingCoach = coachRepo.findById(id).get();
        if(coach.getFullName() != null){ editingCoach.setFullName(coach.getFullName());}
        if(coach.getPhoneNumber() != null){ editingCoach.setPhoneNumber(coach.getPhoneNumber());}
        if(coach.getEmail() != null){ editingCoach.setEmail(coach.getEmail());}
        coachRepo.save(editingCoach);
        return "Данные тренера изменены";
    }
    public Coach readOne(Long id) throws ObjectNotFoundException {
        CoachEntity coach = coachRepo.findById(id).get();
        if(coach == null){
            throw new ObjectNotFoundException("Записи с таким тренером не существует");
        }
        return Coach.toModel(coach);
    }
    public List<Coach> readAll() throws ObjectNotFoundException {
        List<Coach> coachList = new ArrayList<>();
        for(CoachEntity coach : coachRepo.findAll()){
            coachList.add(Coach.toModel(coach));
        }
        if(coachList == null){
            throw new ObjectNotFoundException("Тренеры отсутствуют");
        }
        return coachList;
    }

    public String deleteCoach(Long id){
        coachRepo.deleteById(id);
        return "Тренер удалён";
    }
}
