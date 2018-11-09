package com.training.config;

import com.training.entities.training.swim.IndoorSwim;
import com.training.entities.training.swim.SwimmingPlace;
import com.training.repo.training.swim.ISwimTrainingRepository;
import com.training.repo.training.swim.ISwimmingPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class DBPopulator implements CommandLineRunner {

    @Autowired
    ISwimmingPlaceRepository swimmingPlaceRepository;

    @Autowired
    ISwimTrainingRepository swimTrainingRepository;

    @Override
    public void run(String... args) {

        swimmingPlaceRepository.deleteAll();

        SwimmingPlace swimmingPlaceMitte = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Mitte").address("Wohlbeck Str.").build());
        SwimmingPlace swimmingPlaceOst = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Ost").address("Hafenstraße").build());

        swimTrainingRepository.save(IndoorSwim.builder().date(new Date()).description("sehr gut").swimmingPlace(swimmingPlaceMitte).build());
        swimTrainingRepository.save(IndoorSwim.builder().date(new Date()).description("interessant").swimmingPlace(swimmingPlaceOst).build());
    }
}
