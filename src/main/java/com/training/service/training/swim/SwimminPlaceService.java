package com.training.service.training.swim;

import com.training.entities.training.swim.SwimmingPlace;
import com.training.repo.training.swim.ISwimmingPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwimminPlaceService implements ISwimminPlaceService {

    @Autowired
    private ISwimmingPlaceRepository swimmingPoolRepository;

    @Override
    public SwimmingPlace findById(Long id) {
        return this.swimmingPoolRepository.findById(id).get();
    }

	@Override
	public Iterable<SwimmingPlace> getAll() {
		return this.swimmingPoolRepository.findAll();
	}
}
