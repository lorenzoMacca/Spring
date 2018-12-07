package com.training.controller.training.swim;

import com.fasterxml.jackson.databind.JsonNode;
import com.querydsl.core.types.Predicate;
import com.training.core.training.swim.SwimMonatView;
import com.training.entities.training.swim.IndoorSwim;
import com.training.entities.training.swim.SwimTrainingPattern;
import com.training.entities.training.swim.SwimmingPlace;
import com.training.service.training.swim.ISwimminPlaceService;
import com.training.service.training.swim.SwimService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SwimController {

    @Autowired
    SwimService swimService;

    @Autowired
    ISwimminPlaceService swimminPoolService;


    /**
     *
     * controller for swim activities
     */

    @GetMapping("/swims")
    public List<IndoorSwim> getAllSwimActivities(){
    	List<IndoorSwim> res = (List<IndoorSwim>) this.swimService.getAllIndorSwimActivities();
        Collections.sort(res);
        return res;
    }

    @GetMapping("/training/swim/activities_by_user_id")
    public Iterable<IndoorSwim> getAllSwimActivitiesByUserId(
            @QuerydslPredicate(root = IndoorSwim.class) Predicate predicate
            ){
        return this.swimService.getAllIndorSwimActivities(predicate);
    }

    @DeleteMapping("/training/swim/activity/delete")
    public Boolean deleteSwimActivityById(
            @RequestParam(name = "activityId", required = true) Long activityId
    ){
        return this.swimService.delete(activityId);
    }

    @PostMapping("/sessions/{sessionId}/indorSwims/")
    public ResponseEntity<IndoorSwim> saveIndorSwimActivity(
            @RequestBody JsonNode indoorSwimJson,
            @PathVariable(value="sessionId") Long sessionId
    ){
    	IndoorSwim indoorSwimFromDb = this.swimService.save(sessionId, indoorSwimJson);
        return new ResponseEntity<>(indoorSwimFromDb, HttpHeaders.EMPTY, HttpStatus.CREATED);
    }
    
    @GetMapping("/swims/month_view")
    public List<SwimMonatView> getAllSwimActivitiesMonatView(){
    	return this.swimService.getAllSwimActivitiesMonatView();
    }
    
    @GetMapping("/swims/{page}/{size}")
    public Iterable<IndoorSwim> getAllSwimsWithPaging(
    		@PathVariable("size") int size,
    		@PathVariable("page") int page
    		){
    	return this.swimService.getAllIndorSwimActivitiesWithPaging(page, size);
    }
    
    @GetMapping("/swimming-places")
    public Iterable<SwimmingPlace> getAllSwimPlaces(){
    	return this.swimminPoolService.getAll();
    }
    
    @GetMapping("/swim-training-pattern")
    public Iterable<SwimTrainingPattern> getAllSwimTrainingPattern(){
    	return this.swimService.getAllSwimTrainingPattern();
    }

}
