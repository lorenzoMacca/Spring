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
import com.training.entities.common.UtilsConverter;
import com.training.entities.training.session.Session;
import com.training.entities.training.user.User;
import com.training.repo.training.session.ISessionRepository;
import com.training.repo.training.swim.ISwimTRainingPatternRepository;
import com.training.repo.training.swim.ISwimmingPlaceRepository;
import com.training.repo.user.IUserRepository;

import jsonutils.DataTimeUtils;
import jsonutils.JsonUtils;

//{
//	"date":"2018-11-21",
//	"time":"17:30",
//	"description":"",
//	"duration":"30",
//	"numberOfLaps":"50",
//	"swimmingPlace":"2344",
//	"pattern":"2340",
//	"users": ["2337", "2338"],
//	"session":"2376",
//	"poolLength":"POOL_LENGTH_25_METER"
//}

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
	@Autowired
	ISessionRepository sessionRepository;
	@Autowired
	UtilsConverter utilsConverter;
	private JsonUtils jsonUtils= new JsonUtils();
		
	@Override
	public IndoorSwim convert(JsonNode node) {
		
		DataTimeUtils dataTimeUtils = this.jsonUtils.extractDateAndTime(node);
		
		String description = node.get("description").textValue();
		Double duration = this.jsonUtils.extractDouble(node, "duration");
		Double movDuration = this.jsonUtils.extractDouble(node, "movementDuration");
		Integer numberOfLaps = Integer.parseInt(node.get("numberOfLaps").textValue());
		SwimmingPlace swimmingPlace = this.swimminPlaceRepository.getOne(Long.parseLong((node.get("swimmingPlace").textValue())));
		
		List<User> users = this.utilsConverter.extractUsers(node, this.userRepository);
		
		PoolLength poolLength = PoolLength.valueOf(node.get("poolLength").textValue());
		
		Session session = Session.builder().build();
        Session sessionFromDb = this.sessionRepository.save(session); //this.sessionRepositor.getOne(Long.parseLong((node.get("session").textValue())));

		
		IndoorSwim indoorSwim = IndoorSwim.builder().date(dataTimeUtils.getDate())
				.description(description)
				.duration(duration)
				.numberOfLaps(numberOfLaps)
				.poolLength(poolLength)
				.session(sessionFromDb)
				.time(dataTimeUtils.getTime())
				.swimmingPlace(swimmingPlace)
				.users(users)
				.movementDuration(movDuration)
				.build();
		
		return indoorSwim;
	}

	
}
