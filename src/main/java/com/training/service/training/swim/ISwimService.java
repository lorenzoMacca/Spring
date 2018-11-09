package com.training.service.training.swim;

import com.training.entities.training.swim.IndoorSwim;

public interface ISwimService {

    Iterable<IndoorSwim> getAllIndorSwimActivities();

    Boolean delete(Long indoorSwimId);

    IndoorSwim saveIndorSwimActivity(Long id, String date, String description, Long swimmingPlaceId);
}
