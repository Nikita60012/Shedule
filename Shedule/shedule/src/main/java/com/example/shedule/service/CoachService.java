package com.example.shedule.service;

import com.example.shedule.entity.CoachEntity;
import com.example.shedule.exceptions.ObjectAlreadyExistException;
import com.example.shedule.exceptions.ObjectNotFoundException;
import com.example.shedule.model.Coach;
import com.example.shedule.repository.CoachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {
    @Autowired
    private CoachRepo coachRepo;
    public CoachEntity registration(CoachEntity coach) throws ObjectAlreadyExistException {
       // if(coachRepo.findByCoachName(coach.getFullName()) != null){
       //     throw new CoachAlreadyExistException("Такой тренер уже существует");
       // }
        return coachRepo.save(coach);
    }
    public Coach getOne(Long id) throws ObjectNotFoundException {
        CoachEntity coach = coachRepo.findById(id).get();
        if(coach == null){
            throw new ObjectNotFoundException("Записи с таким тренером не существует");
        }
        return Coach.toModel(coach);
    }
    /*public Coach getAll() throws CoachNotFoundException {
        List<Coach> coachList = coachRepo.findAll().stream().map(Coach::toModel).collect(Collectors.toList());
        if(coachList == null){
            throw new CoachNotFoundException("Тренеры отсутствуют");
        }
        return coachRepo.findAll();
    }

     */
    public String deleteCoach(Long id){
        coachRepo.deleteById(id);
        return "Тренер удалён";
    }
}
