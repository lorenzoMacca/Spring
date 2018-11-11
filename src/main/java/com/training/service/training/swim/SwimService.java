package com.training.service.training.swim;

import com.querydsl.core.types.Predicate;
import com.training.entities.training.swim.IndoorSwim;
import com.training.entities.training.swim.SwimmingPlace;
import com.training.repo.training.swim.ISwimTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SwimService {

    @Autowired
    ISwimTrainingRepository swimTrainingRepository;

    @Autowired
    ISwimminPlaceService swimminPlaceService;

    public Iterable<IndoorSwim> getAllIndorSwimActivities() {
        return this.swimTrainingRepository.findAll();
    }

    public Iterable<IndoorSwim> getAllIndorSwimActivities(Predicate predicate){
        return this.swimTrainingRepository.findAll(predicate);
    }

    public Boolean delete(Long indoorSwimId) {
        this.swimTrainingRepository.deleteById(indoorSwimId);
        return this.swimTrainingRepository.existsById(indoorSwimId);
    }

    public IndoorSwim saveIndorSwimActivity(Long id, String date, String description, Long swimmingPlaceId) {
        try {
            SwimmingPlace swimmingPlace = this.swimminPlaceService.findById(swimmingPlaceId);
            Date d = new Date();
            //TODO: convert data
            IndoorSwim indoorSwim = IndoorSwim.builder().id(id).date(d).description(description).swimmingPlace(swimmingPlace).build();
            this.swimTrainingRepository.save(indoorSwim);
        }catch (IllegalArgumentException e){
            //TODO: log exception
        }finally {
            return null;
        }


    }


}
