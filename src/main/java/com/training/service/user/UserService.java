package com.training.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entities.training.user.User;
import com.training.repo.user.IUserRepository;

@Service
public class UserService {

	@Autowired
	private IUserRepository userRepository;
	
	public Iterable<User> getAllUser(){
		return this.userRepository.findAll();
	}
}
