package com.training.entities.training.exercise;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseRep {
	
	@Id
    @GeneratedValue
    @NotNull
    private Long id;
	
	@NotNull
	@ManyToOne
	@JsonBackReference
	ExerciseSet exerciseSet;
	
	@NotNull
	Double value;

}
