package com.training.controller.training.swim;

import com.querydsl.core.types.Predicate;
import com.training.core.training.swim.SwimMonatView;
import com.training.entities.training.swim.IndoorSwim;
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

    @PostMapping("/indorSwim/")
    public ResponseEntity<IndoorSwim> saveIndorSwimActivity(
            @RequestBody String indoorSwimJson
    ){
    	IndoorSwim indoorSwimFromDb = this.swimService.save(indoorSwimJson);
    	HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(indoorSwimFromDb, headers, HttpStatus.CREATED);
    }
    
    @GetMapping("/swims/month_view")
    public List<SwimMonatView> getAllSwimActivitiesMonatView(){
    	return this.swimService.getAllSwimActivitiesMonatView();
    }
    
    @GetMapping("/swims/{page}/{size}")
    Iterable<IndoorSwim> getAllSwimsWithPaging(
    		@PathVariable("size") int size,
    		@PathVariable("page") int page
    		){
    	return this.swimService.getAllIndorSwimActivitiesWithPaging(page, size);
    }

}
