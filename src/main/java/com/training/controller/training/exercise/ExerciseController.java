package com.training.controller.training.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.training.entities.training.exercise.Exercise;
import com.training.service.training.exercise.ExerciseService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class ExerciseController {

	@Autowired
	private ExerciseService exerciseService;
	
	@GetMapping("/sessions/{sessionId}/exercises")
	public Iterable<Exercise> getAllExerciseBySessionId(@PathVariable(value="sessionId") Long sessionId){
		return this.exerciseService.getAllExerciseActivitiesBySessionId(sessionId);
	}
	
	@GetMapping("/exercises")
	public Iterable<Exercise> getAllExercise(){
		return this.exerciseService.getAllExerciseActivities();
	}
	
	@GetMapping("/exercises/{page}/{size}")
	public Iterable<Exercise> getAllExercisesWithPaging(@PathVariable(value="page") int page, @PathVariable(value="size") int size){
		return this.exerciseService.getAllExerciseActivities(page, size);
	}
	
	@DeleteMapping("/exercises/{id}")
	public ResponseEntity<String> deleteExercise(@PathVariable(value="id") Long id){
		String res = this.exerciseService.deleteExercise(id);
		return new ResponseEntity<>(res, HttpHeaders.EMPTY, HttpStatus.OK);
	}
	
	@PostMapping("session/{sessionId}/exercises")
	public ResponseEntity<Exercise> createExercise(@PathVariable(value="sessionId") Long sessionId, @RequestBody JsonNode jsonNode){
		Exercise exercise = this.exerciseService.saveExercise(sessionId, jsonNode);
		return new ResponseEntity<>(exercise, HttpHeaders.EMPTY, HttpStatus.CREATED);
	}
	

	
}
