package com.training.entities.health.Bodymeasurement;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.training.entities.health.Health;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodyMeasurement implements Comparable<BodyMeasurement>{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private LocalDate date;
	
	private Double weight;
	
	private Double upperArm;
	
	private Double chest;
	
	private Double waist;
	
	private Double hips;
	
	private Double thigh;
	
	@NotNull
    @ManyToOne
    @JsonBackReference
	private Health health;

	@Override
	public int compareTo(BodyMeasurement arg0) {
		return arg0.getDate().compareTo(this.date);
	}
	
	

}
