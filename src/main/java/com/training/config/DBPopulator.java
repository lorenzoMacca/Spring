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
        SwimTrainingPattern p400p300 = SwimTrainingPattern.builder().pattern("400-300").build();
        
        swimTRainingPatternRepository.save(p250p150p100);
        swimTRainingPatternRepository.save(p300p200p100);
        swimTRainingPatternRepository.save(p300p200);
        swimTRainingPatternRepository.save(p400p300);
        
        SwimmingPlace hallenbadHiltrup = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Hiltrup").address("Westfalenstraße 201 48165 Münster").build());
        SwimmingPlace hallenbadOst = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Ost").address("Mauritz-Lindenweg 101 48145 Münster").build());
        SwimmingPlace kielHoern = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hörnbad").address("Anni-Wadle-Weg 1, 24143 Kiel").build());
        SwimmingPlace hallenbadMitte = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Mitte").address("Badestr. 8 48149 Münster").build());
        SwimmingPlace kinderhause = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Kinderhause").address("Badestr. 8 48149 Münster").build());
        SwimmingPlace MuellerschesVolksbad = swimmingPlaceRepository.save(SwimmingPlace.builder().name("MuellerschesVolksbad").address("Badestr. 8 48149 Münster").build());
        SwimmingPlace piscinaScorpion = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Scorpion").address("Via Repaci, 40, 87036 Roges CS, Italien").build());

        
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
        
        Session s11 = Session.builder().build();
        this.sessionRepository.save(s11);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 27))
                .time(LocalTime.of(19, 30))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(60)
                .duration(39.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p400p300)
                .session(s11)
                .build());
        
        Session s12 = Session.builder().build();
        this.sessionRepository.save(s12);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 11, 30))
                .time(LocalTime.of(19, 00))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(62)
                .duration(42.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s12)
                .build());
        
        Session s13 = Session.builder().build();
        this.sessionRepository.save(s13);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 1))
                .time(LocalTime.of(12, 00))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(52)
                .duration(37.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s13)
                .build());
        
        Session s14 = Session.builder().build();
        this.sessionRepository.save(s14);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 4))
                .time(LocalTime.of(18, 00))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(60)
                .duration(45.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s14)
                .build());
        
        Session s15 = Session.builder().build();
        this.sessionRepository.save(s15);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 6))
                .time(LocalTime.of(19, 00))
                .swimmingPlace(hallenbadHiltrup)
                .numberOfLaps(64)
                .duration(43.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s15)
                .build());
        
        Session s16 = Session.builder().build();
        this.sessionRepository.save(s16);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 10))
                .time(LocalTime.of(18, 45))
                .swimmingPlace(hallenbadMitte)
                .numberOfLaps(64)
                .duration(47.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s16)
                .build());
        
        Session s17 = Session.builder().build();
        this.sessionRepository.save(s17);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 13))
                .time(LocalTime.of(18, 45))
                .swimmingPlace(hallenbadHiltrup)
                .numberOfLaps(64)
                .duration(46.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s17)
                .build());
        
        Session s18 = Session.builder().build();
        this.sessionRepository.save(s18);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 16))
                .time(LocalTime.of(10, 30))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(64)
                .duration(50.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(lorenzoUser)
                .pattern(p300p200)
                .session(s18)
                .build());
        
        Session s19 = Session.builder().build();
        this.sessionRepository.save(s19);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 17))
                .time(LocalTime.of(18, 30))
                .swimmingPlace(hallenbadMitte)
                .numberOfLaps(68)
                .duration(49.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s19)
                .build());
        
        Session s20 = Session.builder().build();
        this.sessionRepository.save(s20);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 20))
                .time(LocalTime.of(6, 30))
                .swimmingPlace(kinderhause)
                .numberOfLaps(60)
                .duration(38.09)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(lorenzoUser)
                .pattern(p300p200)
                .session(s20)
                .build());
        
        Session s21 = Session.builder().build();
        this.sessionRepository.save(s21);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 23))
                .time(LocalTime.of(9, 00))
                .swimmingPlace(MuellerschesVolksbad)
                .numberOfLaps(48)
                .duration(42.00)
                .poolLength(PoolLength.POOL_LENGTH_31_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s21)
                .build());
        
        Session s22 = Session.builder().build();
        this.sessionRepository.save(s22);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 27))
                .time(LocalTime.of(11, 33))
                .swimmingPlace(piscinaScorpion)
                .numberOfLaps(60)
                .duration(42.29)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s22)
                .build());
        
        Session s23 = Session.builder().build();
        this.sessionRepository.save(s23);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2018, 12, 30))
                .time(LocalTime.of(13, 18))
                .swimmingPlace(kielHoern)
                .numberOfLaps(36)
                .duration(51.0)
                .poolLength(PoolLength.POOL_LENGTH_50_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s23)
                .build());
        
        Session s24 = Session.builder().build();
        this.sessionRepository.save(s24);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2019, 1, 2))
                .time(LocalTime.of(17, 39))
                .swimmingPlace(hallenbadMitte)
                .numberOfLaps(60)
                .duration(41.53)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s24)
                .build());
        
        Session s25 = Session.builder().build();
        this.sessionRepository.save(s25);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2019, 1, 4))
                .time(LocalTime.of(16, 26))
                .swimmingPlace(hallenbadMitte)
                .numberOfLaps(64)
                .duration(40.08)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(lorenzoUser)
                .pattern(p300p200)
                .session(s25)
                .build());
        
        Session s26 = Session.builder().build();
        this.sessionRepository.save(s26);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2019, 1, 5))
                .time(LocalTime.of(14, 39))
                .swimmingPlace(hallenbadMitte)
                .numberOfLaps(32)
                .duration(21.0)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s26)
                .build());
        
        Session s27 = Session.builder().build();
        this.sessionRepository.save(s27);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2019, 1, 7))
                .time(LocalTime.of(18, 05))
                .swimmingPlace(hallenbadMitte)
                .numberOfLaps(68)
                .duration(45.10)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(lorenzoUser)
                .pattern(p300p200)
                .session(s27)
                .build());
        
        Session s28 = Session.builder().build();
        this.sessionRepository.save(s28);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2019, 1, 9))
                .time(LocalTime.of(18, 57))
                .swimmingPlace(hallenbadMitte)
                .numberOfLaps(60)
                .duration(39.25)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s28)
                .build());
        
        Session s29 = Session.builder().build();
        this.sessionRepository.save(s29);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2019, 1, 12))
                .time(LocalTime.of(12, 01))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(68)
                .duration(46.30)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s29)
                .build());
        
        Session s30 = Session.builder().build();
        this.sessionRepository.save(s30);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2019, 1, 15))
                .time(LocalTime.of(17, 11))
                .swimmingPlace(hallenbadOst)
                .numberOfLaps(64)
                .duration(40.44)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s30)
                .build());
        
        Session s31 = Session.builder().build();
        this.sessionRepository.save(s31);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(LocalDate.of(2019, 1, 17))
                .time(LocalTime.of(17, 01))
                .swimmingPlace(hallenbadHiltrup)
                .numberOfLaps(64)
                .duration(43.35)
                .poolLength(PoolLength.POOL_LENGTH_25_METER)
                .users(buddies)
                .pattern(p300p200)
                .session(s31)
                .build());
        
    }
}
