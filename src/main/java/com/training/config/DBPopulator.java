package com.training.config;

import com.training.core.training.swim.PoolLength;
import com.training.entities.training.exercise.Exercise;
import com.training.entities.training.exercise.ExerciseRep;
import com.training.entities.training.exercise.ExerciseSet;
import com.training.entities.training.exercise.ExerciseType;
import com.training.entities.training.session.Session;
import com.training.entities.training.swim.IndoorSwim;
import com.training.entities.training.swim.SwimTrainingPattern;
import com.training.entities.training.swim.SwimmingPlace;
import com.training.entities.training.user.User;
import com.training.repo.training.exercise.IExerciseRepRepository;
import com.training.repo.training.exercise.IExerciseSetRepository;
import com.training.repo.training.exercise.IExerciseTrainingRepository;
import com.training.repo.training.exercise.IExerciseTypeRepository;
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
    @Autowired
    IExerciseTypeRepository exerciseTypeRepository;
    @Autowired
    IExerciseTrainingRepository exerciseRepository;
    @Autowired
    IExerciseSetRepository setRepository;
    @Autowired
    IExerciseRepRepository repsRepository;

    @Override
    public void run(String... args) {
    	

        userRepository.deleteAllInBatch();
        sessionRepository.deleteAll();
        swimmingPlaceRepository.deleteAll();
        swimTRainingPatternRepository.deleteAll();
        exerciseTypeRepository.deleteAll();

        User lorenzo = User.builder().name("Lorenzo").surname("cozza").build();
        userRepository.save(lorenzo);

        User daniela = User.builder().name("Daniela").surname("Gutschmidt").build();
        userRepository.save(daniela);
        
        ExerciseType plank = ExerciseType.builder().name("Plank").description("abs core").build();
        this.exerciseTypeRepository.save(plank);        
        
        List<User> buddies = new ArrayList<>();
        buddies.add(lorenzo);
        buddies.add(daniela);

        List<User> lorenzoUser = new ArrayList<>();
        lorenzoUser.add(lorenzo);


        SwimTrainingPattern p300p200p100 = SwimTrainingPattern.builder().pattern("300-200-100").build();
        SwimTrainingPattern p250p150p100 = SwimTrainingPattern.builder().pattern("250-150-100").build();
        SwimTrainingPattern p300p200 = SwimTrainingPattern.builder().pattern("300-200").build();
        swimTRainingPatternRepository.save(p250p150p100);
        swimTRainingPatternRepository.save(p300p200p100);
        swimTRainingPatternRepository.save(p300p200);
        
        SwimmingPlace hallenbadHiltrup = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Hiltrup").address("Westfalenstraße 201 48165 Münster").build());
        SwimmingPlace hallenbadOst = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Ost").address("Mauritz-Lindenweg 101 48145 Münster").build());
        SwimmingPlace kielHoern = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hörnbad").address("Anni-Wadle-Weg 1, 24143 Kiel").build());
        SwimmingPlace hallenbadMitte = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Mitte").address("Badestr. 8 48149 Münster").build());

        Session s1 = Session.builder().build();
        this.sessionRepository.save(s1);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 8))
                .time(LocalTime.of(19, 21))
                .description("Great feelings in the new pool in Kiel. pattern: 250-150-100")
                .swimmingPlace(hallenbadHiltrup)
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
                .swimmingPlace(hallenbadHiltrup)
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
                .swimmingPlace(hallenbadHiltrup)
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
                .swimmingPlace(hallenbadMitte)
                .numberOfLaps(48)
                .duration(40.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(lorenzoUser)
                .pattern(p300p200p100)
                .session(s5)
                .build());
        
        Session s6 = Session.builder().build();
        this.sessionRepository.save(s6);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 18))
                .time(LocalTime.of(13, 30))
                .swimmingPlace(hallenbadMitte)
                .numberOfLaps(60)
                .duration(48.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200p100)
                .session(s6)
                .build());
        
        Session s7 = Session.builder().build();
        this.sessionRepository.save(s7);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 20))
                .time(LocalTime.of(18, 30))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(60)
                .duration(48.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s7)
                .build());
        
        Session s8 = Session.builder().build();
        this.sessionRepository.save(s8);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 23))
                .time(LocalTime.of(17, 30))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(60)
                .duration(45.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s8)
                .build());
        
        Session s9 = Session.builder().build();
        this.sessionRepository.save(s9);
        Exercise e9 = Exercise.builder()
		.date(LocalDate.of(2018, 11, 25))
        .time(LocalTime.of(11, 00))
        .duration(10.0)
        .users(lorenzoUser)
        .exerciseType(plank)
        .session(s9)
        .build();
        this.exerciseRepository.save(e9);
        ExerciseSet es91 = ExerciseSet.builder().exercise(e9).build();
        this.setRepository.save(es91);
        this.repsRepository.save(ExerciseRep.builder()
        		.value(60.0)
        		.exerciseSet(es91)
        		.build());
        ExerciseSet es92 = ExerciseSet.builder().exercise(e9).build();
        this.setRepository.save(es92);
        this.repsRepository.save(ExerciseRep.builder()
        		.value(60.0)
        		.exerciseSet(es92)
        		.build());
        
        Session s10 = Session.builder().build();
        this.sessionRepository.save(s10);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 25))
                .time(LocalTime.of(15, 00))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(60)
                .duration(40.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s10)
                .build());
    }
}
