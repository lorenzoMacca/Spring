package com.training.service.training.exercise;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.training.entities.training.exercise.Exercise;
import com.training.entities.training.exercise.QExercise;
import com.training.entities.training.session.Session;
import com.training.repo.training.exercise.IExerciseRepRepository;
import com.training.repo.training.exercise.IExerciseSetRepository;
import com.training.repo.training.exercise.IExerciseTrainingRepository;
import com.training.repo.training.exercise.IExerciseTypeRepository;
import com.training.repo.training.session.ISessionRepository;

@Service
public class ExerciseService {

	@Autowired
	private IExerciseTrainingRepository exerciseTrainingRepository;
	@Autowired
	private IExerciseTypeRepository exerciseTypeRepository;
	@Autowired
	private IExerciseRepRepository repsRepository;
	@Autowired
	private IExerciseSetRepository setsRepository;
	@Autowired
	private ISessionRepository sessionRepository;
	
	
	public Iterable<Exercise> getAllExerciseActivities() {
		return this.exerciseTrainingRepository.findAll();
	}

	public Iterable<Exercise> getAllExerciseActivities(int page, int size) {
		return this.exerciseTrainingRepository.findAll(PageRequest.of(page, size));
	}

	public Iterable<Exercise> getAllExerciseActivitiesBySessionId(Long sessionId) {
		return this.exerciseTrainingRepository.findAll(QExercise.exercise.session.id.eq(sessionId));
	}

	public String deleteExercise(Long id) {
		this.exerciseTrainingRepository.deleteById(id);
		return "{}";
	}

	public Exercise saveExercise(Long sessionId, JsonNode jsonNode) {
		Session session = this.sessionRepository.findById(sessionId).get();
		LocalDate date = LocalDate.parse(jsonNode.get("date").textValue(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalTime time = LocalTime.parse(jsonNode.get("date").textValue(), DateTimeFormatter.ofPattern("hh:mm"));
		Double duration = jsonNode.get("duration").asDouble();
		
		return null;
	}
	
	
}
