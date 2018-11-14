package com.training.controller.training.session;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entities.training.session.Session;
import com.training.service.training.session.SessionService;

@RestController
public class SessionController {
	
	@Autowired
	private SessionService sessionService;

	@GetMapping("/training/session")
	public List<Session> getAllSessions(){
		return this.sessionService.getAll();
	}
}
