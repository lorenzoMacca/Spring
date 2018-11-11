package com.training.config;

import com.training.core.training.swim.PoolLength;
import com.training.entities.training.swim.IndoorSwim;
import com.training.entities.training.swim.SwimmingPlace;
import com.training.entities.training.user.User;
import com.training.repo.training.swim.ISwimTrainingRepository;
import com.training.repo.training.swim.ISwimmingPlaceRepository;
import com.training.repo.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.util.Date;


@Component
public class DBPopulator implements CommandLineRunner {

    @Autowired
    ISwimmingPlaceRepository swimmingPlaceRepository;

    @Autowired
    ISwimTrainingRepository swimTrainingRepository;

    @Autowired
    IUserRepository userRepository;

    @Override
    public void run(String... args) {

        userRepository.deleteAll();
        swimmingPlaceRepository.deleteAll();

        User lorenzo = User.builder().name("Lorenzo").surname("cozza").build();
        userRepository.save(lorenzo);

        User daniela = User.builder().name("Daniela").surname("Gutschmidt").build();
        userRepository.save(daniela);

        SwimmingPlace swimmingPlaceMitte = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Mitte").address("Wohlbeck Str.").build());
        SwimmingPlace swimmingPlaceOst = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Ost").address("Hafenstraße").build());

        swimTrainingRepository.save(IndoorSwim.builder()
                .date(new Date())
                .description("sehr gut")
                .swimmingPlace(swimmingPlaceMitte)
                .numberOfLaps(25)
                .duration(55.0)
                .poolLength(PoolLength.POOL_LENGTH_50_METER)
                .user(daniela)
                .build());

        swimTrainingRepository.save(IndoorSwim.builder()
                .date(new Date())
                .description("interessant")
                .numberOfLaps(25)
                .duration(55.0)
                .user(lorenzo)
                .poolLength(PoolLength.POOL_LENGTH_50_METER)
                .swimmingPlace(swimmingPlaceOst)
                .build());
    }
}
