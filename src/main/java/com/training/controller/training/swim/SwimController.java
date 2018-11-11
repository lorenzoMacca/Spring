package com.training.controller.training.swim;

import com.training.entities.training.swim.IndoorSwim;
import com.training.service.training.swim.ISwimService;
import com.training.service.training.swim.ISwimminPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SwimController {

    @Autowired
    ISwimService swimService;

    @Autowired
    ISwimminPlaceService swimminPoolService;


    @GetMapping("/training/swim/activities")
    public Iterable<IndoorSwim> getAllSwimActivities(){
        return this.swimService.getAllIndorSwimActivities();
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
        return this.swimService.saveIndorSwimActivity(id, date, description, swimmingPlaceId);
    }
}
