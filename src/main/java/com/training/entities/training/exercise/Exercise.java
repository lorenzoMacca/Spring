package com.training.entities.training.exercise;

import java.time.LocalDate;
import java.time.LocalTime;
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
public class Exercise implements Comparable<Exercise>{
	
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
    
    @NotNull
    @ManyToOne
    @JsonBackReference
    ExerciseType exerciseType;

	@Override
	public int compareTo(Exercise o) {
		Exercise e = (Exercise)o;
		return e.getDate().compareTo(this.getDate());
	}

}
