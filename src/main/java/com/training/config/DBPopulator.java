package com.training.config;

import com.training.entities.training.swim.IndoorSwim;
import com.training.entities.training.swim.SwimmingPool;
import com.training.repo.training.swim.ISwimTrainingRepository;
import com.training.repo.training.swim.ISwimmingPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class DBPopulator implements CommandLineRunner {

    @Autowired
    ISwimmingPoolRepository swimmingPoolRepository;

    @Autowired
    ISwimTrainingRepository swimTrainingRepository;

    @Override
    public void run(String... args) {

        swimmingPoolRepository.deleteAll();

        SwimmingPool swimmingPoolMitte = swimmingPoolRepository.save(SwimmingPool.builder().name("Mitte").address("Wohlbeck Str.").build());
        SwimmingPool swimmingPoolOst = swimmingPoolRepository.save(SwimmingPool.builder().name("Ost").address("Hafenstraße").build());

        swimTrainingRepository.save(IndoorSwim.builder().date(new Date()).description("sehr gut").swimmingPool(swimmingPoolMitte).build());
        swimTrainingRepository.save(IndoorSwim.builder().date(new Date()).description("interessant").swimmingPool(swimmingPoolOst).build());
    }
}
