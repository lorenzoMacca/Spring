package com.training.entities.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.training.entities.training.user.User;
import com.training.repo.user.IUserRepository;

@Component
public class UtilsConverter {
	
	public List<User> extractUsers(JsonNode node, IUserRepository userRepository){
		List<User> users = new ArrayList<>();
		JsonNode arrNode = node.get("users");
		if(arrNode.isArray()) {
			for (JsonNode jsonNode : arrNode) {
				Long userId = Long.parseLong(jsonNode.toString().replaceAll("\"", ""));
				users.add(userRepository.getOne(userId));
			}
		}
		return users;
	}
	

}
