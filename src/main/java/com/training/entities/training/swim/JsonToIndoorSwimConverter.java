package com.training.entities.training.swim;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.training.core.training.swim.PoolLength;
import com.training.entities.common.EntityConverter;
import com.training.entities.training.session.Session;
import com.training.entities.training.user.User;
import com.training.repo.training.session.ISessionRepository;
import com.training.repo.training.swim.ISwimTRainingPatternRepository;
import com.training.repo.training.swim.ISwimmingPlaceRepository;
import com.training.repo.user.IUserRepository;

@Component
public class JsonToIndoorSwimConverter implements EntityConverter<JsonNode, IndoorSwim>{

	@Autowired
    ISwimmingPlaceRepository swimminPlaceRepository;
	@Autowired
	ISwimTRainingPatternRepository patternRepository;
	@Autowired
	ISessionRepository sessionRepositor;
	@Autowired
	IUserRepository userRepository;
		
	@Override
	public IndoorSwim convert(JsonNode node) {
		String dateString = node.get("date").textValue();
		String dateStringSplitted[] = dateString.split("-");
		LocalDate date = LocalDate.of(
				Integer.parseInt(dateStringSplitted[0]), 
				Integer.parseInt(dateStringSplitted[1]), 
				Integer.parseInt(dateStringSplitted[2]));
		
		String timeString = node.get("time").textValue();
		String timeStringSplitted[] = timeString.split(":");
		LocalTime time = LocalTime.of(
				Integer.parseInt(timeStringSplitted[0]),
				Integer.parseInt(timeStringSplitted[1])
				);
		
		String description = node.get("description").textValue();
		Double duration = Double.parseDouble(node.get("duration").textValue());
		Integer numberOfLaps = Integer.parseInt(node.get("numberOfLaps").textValue());
		PoolLength poolLength = PoolLength.POOL_LENGTH_25_METER; //TODO: use correct value
		SwimmingPlace swimmingPlace = this.swimminPlaceRepository.getOne(Long.parseLong((node.get("swimmingPlace").textValue())));
		SwimTrainingPattern pattern = this.patternRepository.getOne(Long.parseLong((node.get("pattern").textValue())));
		
		Session session = this.sessionRepositor.save(Session.builder().build());
		
		List<User> users = new ArrayList<>();
		
		User user = this.userRepository.save(User.builder().name("a").surname("b").build());
		
		IndoorSwim indoorSwim = IndoorSwim.builder().date(date)
				.description(description)
				.duration(duration)
				.numberOfLaps(numberOfLaps)
				.pattern(pattern)
				.poolLength(poolLength)
				.session(session)
				.time(time)
				.swimmingPlace(swimmingPlace)
				.users(users).build();
		
		return indoorSwim;
	}

	
}
