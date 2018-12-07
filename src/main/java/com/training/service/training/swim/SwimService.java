package com.training.service.training.swim;

import com.fasterxml.jackson.databind.JsonNode;
import com.querydsl.core.types.Predicate;
import com.training.core.training.swim.SwimMonatView;
import com.training.entities.common.EntityConverter;
import com.training.entities.training.session.Session;
import com.training.entities.training.swim.IndoorSwim;
import com.training.repo.training.session.ISessionRepository;
import com.training.repo.training.swim.ISwimTrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SwimService {

    @Autowired
    ISwimTrainingRepository swimTrainingRepository;

    @Autowired
    ISwimminPlaceService swimminPlaceService;
    
    @Autowired
    ISessionRepository sessionRepository;
    
    @Autowired
    EntityConverter<JsonNode, IndoorSwim> jsonToIndoorSwimConverter;
    
    public Iterable<IndoorSwim> getAllIndorSwimActivitiesWithPaging(int page, int size) {
        return this.swimTrainingRepository.findAll(PageRequest.of(page, size));
    }

    public Iterable<IndoorSwim> getAllIndorSwimActivities() {
        return this.swimTrainingRepository.findAll();
    }

    public Iterable<IndoorSwim> getAllIndorSwimActivities(Predicate predicate){
        return this.swimTrainingRepository.findAll(predicate);
    }

    public Boolean delete(Long indoorSwimId) {
        this.swimTrainingRepository.deleteById(indoorSwimId);
        return this.swimTrainingRepository.existsById(indoorSwimId);
    }

	public List<SwimMonatView> getAllSwimActivitiesMonatView() {
		List<SwimMonatView> res = new ArrayList<>();
		Iterable<IndoorSwim> swimActivities = this.swimTrainingRepository.findAll();
		for (IndoorSwim indoorSwimI : swimActivities) {
			SwimMonatView swimMonatView = SwimMonatView.builder().month(indoorSwimI.getDate().getMonthValue()).year(indoorSwimI.getDate().getYear()).totalDistance(new Float(0.0)).build();
			boolean alreadyIn = false;
			for (SwimMonatView swimMonatViewTmp : res) {
				if(swimMonatViewTmp.equals(swimMonatView)) {
					alreadyIn = true;
					break;
				}
			}
			if(!alreadyIn) {
				res.add(swimMonatView);
			}
		}
		for (SwimMonatView swimMonatViewTmp : res) {
			for (IndoorSwim indoorSwimI : swimActivities) {
				if(swimMonatViewTmp.getMonth() == indoorSwimI.getDate().getMonthValue() &&
				   swimMonatViewTmp.getYear()  == indoorSwimI.getDate().getYear()) {
					Float tmpDistance = indoorSwimI.getSwimmingPlaceDistance() * indoorSwimI.getNumberOfLaps();
					swimMonatViewTmp.setTotalDistance(swimMonatViewTmp.getTotalDistance()+tmpDistance);
				}
			}
		}
		return res;
		
	}

    public IndoorSwim save(Long sessionId, JsonNode json) {
		IndoorSwim indoorSwim = this.jsonToIndoorSwimConverter.convert(json);
		if(sessionId != indoorSwim.getSession().getId()) {
			Session s = this.sessionRepository.getOne(sessionId);
			indoorSwim.setSession(s);
		}
		return this.swimTrainingRepository.save(indoorSwim);
    }


}
