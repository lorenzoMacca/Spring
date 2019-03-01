package com.training.config;

import com.training.core.training.swim.PoolLength;
import com.training.entities.training.Run;
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
import com.training.repo.training.run.IRunRepository;
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

    @Autowired
    private IRunRepository runRepository;
    
    @Override
    public void run(String... args) {
    	

        userRepository.deleteAllInBatch();
        sessionRepository.deleteAll();
        swimmingPlaceRepository.deleteAll();
        swimTRainingPatternRepository.deleteAll();
        exerciseTypeRepository.deleteAll();

        User lorenzo = User.builder().name("Lorenzo").surname("cozza").description("Hi! my Name is Lorenzo and I live in Münster, DE").picture("").build();
        userRepository.save(lorenzo);

        User daniela = User.builder().name("Daniela").surname("Gutschmidt").description("Hi! my Name is Daniela and I live in Münster und I'm beautiful").picture("daniela_gutschmidt.jpg").build();
        userRepository.save(daniela);
        
        User frodo = User.builder().name("Jan").surname("Frodeno").description("Hi! my Name is Jan and I won the Ironman Hawaii two times").picture("frodo.jpg").build();
        userRepository.save(frodo);
        
        User lange = User.builder().name("Patrick").surname("Lange").description("Hi! my Name is Lange and I won the Ironman Hawaii two times").picture("lange.jpg").build();
        userRepository.save(lange);
        
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
        
        SwimmingPlace hallenbadHiltrup = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Hiltrup").address("Westfalenstraße 201 48165 Münster").longitude(51.900642).latitude(7.6379748).build());
        SwimmingPlace hallenbadOst = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Ost").address("Mauritz-Lindenweg 101 48145 Münster").longitude(51.9484584).latitude(7.5813466).build());
        SwimmingPlace kielHoern = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hörnbad").address("Anni-Wadle-Weg 1, 24143 Kiel").longitude(51.9484584).latitude(7.5813466).build());
        SwimmingPlace hallenbadMitte = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Mitte").address("Badestr. 8 48149 Münster").longitude(51.9484584).latitude(7.5813466).build());
        SwimmingPlace kinderhause = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Hallenbad Kinderhause").address("Badestr. 8 48149 Münster").longitude(51.9484584).latitude(7.5813466).build());
        SwimmingPlace MuellerschesVolksbad = swimmingPlaceRepository.save(SwimmingPlace.builder().name("MuellerschesVolksbad").address("Badestr. 8 48149 Münster").longitude(51.9484584).latitude(7.5813466).build());
        SwimmingPlace piscinaScorpion = swimmingPlaceRepository.save(SwimmingPlace.builder().name("Scorpion").address("Via Repaci, 40, 87036 Roges CS, Italien").longitude(51.9484584).latitude(7.5813466).build());

        
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

        this.insertSwim(LocalDate.of(2018, 12, 12), LocalTime.of(18, 45), 47.0, 64, buddies, hallenbadMitte, PoolLength.POOL_LENGTH_25_METER, null);

        this.insertSwim(LocalDate.of(2018, 12, 13), LocalTime.of(18, 45), 46.0, 64, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, null);
        
        this.insertSwim(LocalDate.of(2018, 12, 16), LocalTime.of(10, 30), 50.0, 64, lorenzoUser, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, null);
        
        this.insertSwim(LocalDate.of(2018, 12, 17), LocalTime.of(18, 30), 49.0, 68, buddies, hallenbadMitte, PoolLength.POOL_LENGTH_25_METER, null);
        
        this.insertSwim(LocalDate.of(2018, 12, 20), LocalTime.of(6, 30), 38.09, 60, lorenzoUser, kinderhause, PoolLength.POOL_LENGTH_25_METER, null);
        
		this.insertSwim(LocalDate.of(2018, 12, 23), LocalTime.of(9, 00), 42.00, 48, buddies, MuellerschesVolksbad, PoolLength.POOL_LENGTH_31_METER, null);
        
		this.insertSwim(LocalDate.of(2018, 12, 27), LocalTime.of(11, 33), 42.29, 60, buddies, piscinaScorpion, PoolLength.POOL_LENGTH_25_METER, 34.30);

		this.insertSwim(LocalDate.of(2018, 12, 30), LocalTime.of(13, 18), 51.0, 36, buddies, kielHoern, PoolLength.POOL_LENGTH_50_METER, 38.07);

        this.insertSwim(LocalDate.of(2019, 1, 2), LocalTime.of(17, 39), 41.53, 60, buddies, hallenbadMitte, PoolLength.POOL_LENGTH_25_METER, 31.41);
        
        this.insertSwim(LocalDate.of(2019, 1, 4), LocalTime.of(10, 26), 40.08, 64, lorenzoUser, hallenbadMitte, PoolLength.POOL_LENGTH_25_METER, 34.04);
        
        this.insertSwim(LocalDate.of(2019, 1, 7), LocalTime.of(18, 05), 45.10, 68, lorenzoUser, hallenbadMitte, PoolLength.POOL_LENGTH_25_METER, 35.47);
        
        this.insertSwim(LocalDate.of(2019, 1, 9), LocalTime.of(18, 57), 39.25, 60, buddies, hallenbadMitte, PoolLength.POOL_LENGTH_25_METER, 32.10);
        
        this.insertRun(LocalDate.of(2019, 1, 10), LocalTime.of(17, 49), 28.18, 5.01, lorenzoUser);
		
		this.insertSwim(LocalDate.of(2019, 1, 12), LocalTime.of(12, 01), 46.30, 68, buddies, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, 34.09);

        this.insertSwim(LocalDate.of(2019, 1, 15), LocalTime.of(17, 11), 40.44, 64, buddies, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, 32.22);
		
		this.insertRun(LocalDate.of(2019, 1, 16), LocalTime.of(16, 01), 33.36, 6.02, lorenzoUser);
        
        this.insertSwim(LocalDate.of(2019, 1, 17), LocalTime.of(17, 01), 43.35, 64, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 35.52);

        this.insertSwim(LocalDate.of(2019, 1, 24), LocalTime.of(18, 05), 33.51, 48, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 26.02);
        
        this.insertSwim(LocalDate.of(2019, 1, 27), LocalTime.of(11, 07), 29.49, 48, buddies, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, 24.38);
        
        this.insertSwim(LocalDate.of(2019, 1, 29), LocalTime.of(18, 38), 39.35, 60, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 31.51);
        
        this.insertSwim(LocalDate.of(2019, 1, 31), LocalTime.of(17, 38), 39.32, 60, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 30.26);
        
        this.insertSwim(LocalDate.of(2019, 2, 3), LocalTime.of(10, 49),  38.45, 64, buddies, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, 34.44);
        
        this.insertSwim(LocalDate.of(2019, 2, 5), LocalTime.of(18, 40),  35.20, 56, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 29.08);
        
        this.insertSwim(LocalDate.of(2019, 2, 7), LocalTime.of(17, 9),   41.03, 64, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 31.44);
        
        this.insertSwim(LocalDate.of(2019, 2, 9), LocalTime.of(8, 30),   32.46, 52, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 26.47);
        
        this.insertSwim(LocalDate.of(2019, 2, 12), LocalTime.of(18, 36),   42.25, 68, buddies, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, 35.17);
        
        this.insertRun(LocalDate.of(2019, 2, 13), LocalTime.of(17, 27), 28.22, 5.19, lorenzoUser);
        
        this.insertSwim(LocalDate.of(2019, 2, 14), LocalTime.of(18, 04),   41.45, 68, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 36.14);
        
        this.insertRun(LocalDate.of(2019, 2, 16), LocalTime.of(10, 46), 32.27, 5.30, buddies);
        
        this.insertSwim(LocalDate.of(2019, 2, 17), LocalTime.of(12, 04),   42.45, 68, buddies, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, 36.00);
		
		this.insertRun(LocalDate.of(2019, 2, 18), LocalTime.of(16, 22), 33.15, 6.03, lorenzoUser);
		
		this.insertSwim(LocalDate.of(2019, 2, 19), LocalTime.of(17, 43),   40.04, 68, buddies, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, 35.01);
		
		this.insertSwim(LocalDate.of(2019, 2, 21), LocalTime.of(17, 9),   42.43, 70, buddies, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 36.05);
		
		this.insertSwim(LocalDate.of(2019, 2, 23), LocalTime.of(10, 45),   40.39, 70, lorenzoUser, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, 35.39);

		this.insertRun(LocalDate.of(2019, 2, 23), LocalTime.of(17, 22), 35.04, 5.24, buddies);
		
		this.insertSwim(LocalDate.of(2019, 2, 26), LocalTime.of(19, 34),   42.04, 70, buddies, hallenbadOst, PoolLength.POOL_LENGTH_25_METER, 35.42);
		
		this.insertRun(LocalDate.of(2019, 2, 27), LocalTime.of(16, 32), 28.31, 5.01, lorenzoUser);

        this.insertSwim(LocalDate.of(2019, 2, 28), LocalTime.of(17, 57),   41.23, 72, lorenzoUser, hallenbadHiltrup, PoolLength.POOL_LENGTH_25_METER, 37.02);

    }
    
    private void insertRun(LocalDate date, LocalTime time, Double duration, Double dinstance, List<User> users) {
    	Session session = Session.builder().build();
        this.sessionRepository.save(session);
        runRepository.save(Run.builder()
        		.date(date)
        		.time(time)
        		.duration(duration)
        		.distance(dinstance)
        		.users(users)
        		.session(session)
        		.build());
    }
    
    private void insertSwim(LocalDate date, LocalTime time, Double duration, Integer laps, List<User> users, SwimmingPlace swimmingPlace, PoolLength poolLength, Double movementDuration) {
    	Session session = Session.builder().build();
        this.sessionRepository.save(session);
        swimTrainingRepository.save(IndoorSwim.builder()
                .date(date)
                .time(time)
                .swimmingPlace(swimmingPlace)
                .numberOfLaps(laps)
                .duration(duration)
                .poolLength(poolLength)
                .users(users)
                .session(session)
                .movementDuration(movementDuration)
                .build());
        
    }
    
}
