package com.training.config;

import com.training.core.training.swim.PoolLength;
import com.training.entities.training.session.Session;
import com.training.entities.training.swim.IndoorSwim;
import com.training.entities.training.swim.SwimTrainingPattern;
import com.training.entities.training.swim.SwimmingPlace;
import com.training.entities.training.user.User;
import com.training.repo.training.session.ISessionRepository;
import com.training.repo.training.swim.ISwimTRainingPatternRepository;
import com.training.repo.training.swim.ISwimTrainingRepository;
import com.training.repo.training.swim.ISwimmingPlaceRepository;
import com.training.repo.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
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
    @Autowired
    ISessionRepository sessionRepository;

    @Override
    public void run(String... args) {

        userRepository.deleteAllInBatch();
        sessionRepository.deleteAll();
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
        SwimmingPlace kielHoern = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Kiel").address("Hafenstraße").build());
        SwimmingPlace mitteSchwimmbad = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Mitte").address("Wohlbeck Str.").build());

        Session s1 = Session.builder().build();
        this.sessionRepository.save(s1);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 8))
                .time(LocalTime.of(19, 21))
                .description("Great feelings in the new pool in Kiel. pattern: 250-150-100")
                .swimmingPlace(HiltrupSchwimmbad)
                .numberOfLaps(54)
                .duration(40.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p250p150p100)
                .session(s1)
                .build());

        Session s2 = Session.builder().build();
        this.sessionRepository.save(s2);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 11))
                .time(LocalTime.of(11, 25))
                .description("Great feelings in the new pool in Kiel. 300-200-100-300-200-100-300")
                .swimmingPlace(kielHoern)
                .numberOfLaps(26)
                .duration(35.0)
                .poolLength(PoolLength.POOL_LENGTH_50_METER)
                .users(lorenzoUser)
                .pattern(p300p200p100)
                .session(s2)
                .build());
        
        Session s3 = Session.builder().build();
        this.sessionRepository.save(s3);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 13))
                .time(LocalTime.of(18,0))
                .swimmingPlace(HiltrupSchwimmbad)
                .numberOfLaps(60)
                .duration(50.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p250p150p100)
                .session(s3)
                .build());
        
        Session s4 = Session.builder().build();
        this.sessionRepository.save(s4);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 15))
                .time(LocalTime.of(18, 0))
                .swimmingPlace(HiltrupSchwimmbad)
                .numberOfLaps(60)
                .duration(50.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p250p150p100)
                .session(s4)
                .build());
        
        Session s5 = Session.builder().build();
        this.sessionRepository.save(s5);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 16))
                .time(LocalTime.of(19, 20))
                .swimmingPlace(mitteSchwimmbad)
                .numberOfLaps(48)
                .duration(40.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(lorenzoUser)
                .pattern(p300p200p100)
                .session(s5)
                .build());
    }
}
