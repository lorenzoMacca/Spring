package com.training.service.training.swim;

import com.training.repo.training.swim.ISwimmingPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwimminPoolService implements ISwimminPoolService {

    @Autowired
    ISwimmingPlaceRepository swimmingPoolRepository;
}
