package com.training.service.training.session;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.entities.training.session.Session;
import com.training.repo.training.session.ISessionRepository;

@Service
public class SessionService {

	@Autowired
	private ISessionRepository sessionRepository;
	
	public List<Session> getAll(){
		return this.sessionRepository.findAll();
	}
}
