package com.training.service.training.swim;

import com.fasterxml.jackson.databind.JsonNode;
import com.querydsl.core.types.Predicate;
import com.training.core.training.swim.SwimMonatView;
import com.training.entities.common.EntityConverter;
import com.training.entities.training.session.Session;
import com.training.entities.training.swim.IndoorSwim;
import com.training.entities.training.swim.QIndoorSwim;
import com.training.entities.training.swim.SwimTrainingPattern;
import com.training.entities.training.user.User;
import com.training.repo.training.session.ISessionRepository;
import com.training.repo.training.swim.ISwimTRainingPatternRepository;
import com.training.repo.training.swim.ISwimTrainingRepository;
import com.training.repo.user.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SwimService {

    @Autowired
    private ISwimTrainingRepository swimTrainingRepository;

    @Autowired
    private ISwimminPlaceService swimminPlaceService;
    
    @Autowired
    private ISessionRepository sessionRepository;
    
    @Autowired
    private ISwimTRainingPatternRepository patternRepository;
    
    @Autowired
    private EntityConverter<JsonNode, IndoorSwim> jsonToIndoorSwimConverter;
    
    public Iterable<IndoorSwim> getAllIndorSwimActivitiesWithPaging(int page, int size) {
        return this.swimTrainingRepository.findAll(PageRequest.of(page, size));
    }

    public Iterable<IndoorSwim> getAllIndorSwimActivities() {
        return this.swimTrainingRepository.findAll();
    }

    public Iterable<IndoorSwim> getAllIndorSwimActivities(Long userId){
    	List<IndoorSwim> indorSwims = new ArrayList<>();
    	for (IndoorSwim indoorSwim : this.swimTrainingRepository.findAll()) {
			for (User u : indoorSwim.getUsers()) {
				if(u.getId().intValue() == userId) {
					indorSwims.add(indoorSwim);
				}
			}
		};
    	return indorSwims;
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

    public IndoorSwim save(JsonNode json) {
		IndoorSwim indoorSwim = this.jsonToIndoorSwimConverter.convert(json);
		return this.swimTrainingRepository.save(indoorSwim);
    }
    
    public Iterable<SwimTrainingPattern> getAllSwimTrainingPattern(){
    	return this.patternRepository.findAll();
    }


}
