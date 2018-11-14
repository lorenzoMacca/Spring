package com.training.config;

import com.training.core.training.swim.PoolLength;
import com.training.entities.training.swim.IndoorSwim;
import com.training.entities.training.swim.SwimTrainingPattern;
import com.training.entities.training.swim.SwimmingPlace;
import com.training.entities.training.user.User;
import com.training.repo.training.swim.ISwimTRainingPatternRepository;
import com.training.repo.training.swim.ISwimTrainingRepository;
import com.training.repo.training.swim.ISwimmingPlaceRepository;
import com.training.repo.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Component
public class DBPopulator implements CommandLineRunner {

    @Autowired
    ISwimmingPlaceRepository swimmingPlaceRepository;
    @Autowired
    ISwimTrainingRepository swimTrainingRepository;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    ISwimTRainingPatternRepository swimTRainingPatternRepository;

    @Override
    public void run(String... args) {

        userRepository.deleteAllInBatch();
        swimmingPlaceRepository.deleteAll();
        swimTRainingPatternRepository.deleteAll();

        User lorenzo = User.builder().name("Lorenzo").surname("cozza").build();
        userRepository.save(lorenzo);

        User daniela = User.builder().name("Daniela").surname("Gutschmidt").build();
        userRepository.save(daniela);

        List<User> buddies = new ArrayList<>();
        buddies.add(lorenzo);
        buddies.add(daniela);

        List<User> lorenzoUser = new ArrayList<>();
        lorenzoUser.add(lorenzo);


        SwimTrainingPattern p300p200p100 = SwimTrainingPattern.builder().pattern("300-200-100").build();
        SwimTrainingPattern p250p150p100 = SwimTrainingPattern.builder().pattern("250-150-100").build();
        swimTRainingPatternRepository.save(p250p150p100);
        swimTRainingPatternRepository.save(p300p200p100);

        SwimmingPlace HiltrupSchwimmbad = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hiltrup").address("Wohlbeck Str.").build());
        SwimmingPlace swimmingPlaceOst = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Ost").address("Hafenstraße").build());
        SwimmingPlace kielHoern = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Ost").address("Hafenstraße").build());

        Calendar c1 = Calendar.getInstance();
        c1.set(2018, Calendar.NOVEMBER, 8, 19, 21);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(c1.getTime())
                .description("Great feelings in the new pool in Kiel. pattern: 250-150-100")
                .swimmingPlace(HiltrupSchwimmbad)
                .numberOfLaps(54)
                .duration(40.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p250p150p100)
                .build());

        Calendar c2 = Calendar.getInstance();
        c2.set(2018, Calendar.NOVEMBER, 11, 11, 25);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(c2.getTime())
                .description("Great feelings in the new pool in Kiel. 300-200-100-300-200-100-300")
                .swimmingPlace(kielHoern)
                .numberOfLaps(26)
                .duration(35.0)
                .poolLength(PoolLength.POOL_LENGTH_50_METER)
                .users(lorenzoUser)
                .pattern(p300p200p100)
                .build());
        
        Calendar c3 = Calendar.getInstance();
        c2.set(2018, Calendar.NOVEMBER, 13, 18, 0);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(c3.getTime())
                .swimmingPlace(HiltrupSchwimmbad)
                .numberOfLaps(60)
                .duration(50.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p250p150p100)
                .build());
    }
}
