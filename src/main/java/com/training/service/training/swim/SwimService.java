package com.training.service.training.swim;

import com.training.entities.training.swim.IndoorSwim;
import com.training.repo.training.swim.ISwimTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwimService implements ISwimService {

    @Autowired
    ISwimTrainingRepository swimTrainingRepository;


    @Override
    public Iterable<IndoorSwim> getAllIndorSwimActivities() {
        return this.swimTrainingRepository.findAll();
    }
}
