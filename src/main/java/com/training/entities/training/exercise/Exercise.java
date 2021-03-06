package com.training.entities.training.exercise;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.entities.training.session.Session;
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
    
    @NotNull
    @ManyToOne
    @JsonBackReference
    Session session;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="exercise")
    @JsonManagedReference
    List<ExerciseSet> sets;
    
    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_exercise",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "exercise_id")}
    )
    @JsonManagedReference
    private List<User> users;

	@Override
	public int compareTo(Exercise o) {
		Exercise e = (Exercise)o;
		return e.getDate().compareTo(this.getDate());
	}

}
