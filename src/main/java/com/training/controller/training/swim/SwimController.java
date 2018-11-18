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

    @GetMapping("/training/swim/activities")
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

    @PutMapping("/training/swim/activity/save")
    public IndoorSwim saveIndorSwimActivity(
            @RequestParam(name = "id", required = false) Long id,
            @RequestParam(name = "date", required = true) String date,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "swimmingPlaceId", required = true) Long swimmingPlaceId
    ){
        return null; //this.swimService.saveIndorSwimActivity(id, date, description, swimmingPlaceId);
    }
    
    @GetMapping("/training/swim/activities/month_view")
    public List<SwimMonatView> getAllSwimActivitiesMonatView(){
    	return this.swimService.getAllSwimActivitiesMonatView();
    }

}
