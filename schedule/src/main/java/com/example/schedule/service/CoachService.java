package com.example.schedule.service;


import com.example.schedule.entity.CoachEntity;
import com.example.schedule.exceptions.CoachAlreadyExistException;
import com.example.schedule.exceptions.CoachNotFoundException;
import com.example.schedule.model.Coach;
import com.example.schedule.repository.CoachRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CoachService {

    @Autowired
    private CoachRepo coachRepo;
    public CoachEntity registration(CoachEntity coach) throws CoachAlreadyExistException {
        if(coachRepo.findByCoachName(coach.getFullName()) != null){
            throw new CoachAlreadyExistException("Такой тренер уже существует");
        }
        return coachRepo.save(coach);
    }
    public Coach getOne(Long id) throws CoachNotFoundException {
        CoachEntity coach = coachRepo.findById(id).get();
        if(coach == null){
            throw new CoachNotFoundException("Записи с таким тренером не существует");
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