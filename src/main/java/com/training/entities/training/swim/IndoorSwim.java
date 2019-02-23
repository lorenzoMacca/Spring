package com.training.entities.training.swim;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.core.training.swim.PoolLength;
import com.training.entities.training.session.Session;
import com.training.entities.training.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndoorSwim implements Comparable<IndoorSwim>{

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotNull
    private LocalDate date;
    
    @NotNull
    private LocalTime time;
    

    private String description;

    @NotNull
    private Double duration;
    
    private Double movementDuration;

    @NotNull
    private Integer numberOfLaps;

    @NotNull
    private PoolLength poolLength;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    private SwimmingPlace swimmingPlace;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_swim",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "indoor_swim_id")}
    )
    @JsonManagedReference
    private List<User> users;


    @ManyToOne
    @JsonManagedReference
    private SwimTrainingPattern pattern;
    
    @NotNull
    @ManyToOne
    @JsonBackReference
    Session session;
    
    public Float getSwimmingPlaceDistance() {
    	if(this.poolLength == PoolLength.POOL_LENGTH_25_METER) {
    		return Float.valueOf(25);
    	}else if(this.poolLength == PoolLength.POOL_LENGTH_50_METER) {
    		return Float.valueOf(50);
    	}else if(this.poolLength == PoolLength.POOL_LENGTH_31_METER) {
    		return Float.valueOf(31);
    	}
    	return null;
    }

	@Override
	public int compareTo(IndoorSwim o) {
		IndoorSwim r = (IndoorSwim)o;
		return r.getDate().compareTo(this.getDate());
	}

	
}
