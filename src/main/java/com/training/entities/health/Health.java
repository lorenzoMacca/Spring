package com.training.entities.health;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.entities.health.Bodymeasurement.BodyMeasurement;
import com.training.entities.training.user.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Health {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="health")
    @JsonManagedReference
	List<BodyMeasurement> bodyMeasurements;
	
	@OneToOne
	@JsonManagedReference
	private User user;
}
