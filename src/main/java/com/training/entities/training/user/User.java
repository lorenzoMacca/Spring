package com.training.entities.training.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.entities.health.Health;
import com.training.entities.training.Run;
import com.training.entities.training.exercise.Exercise;
import com.training.entities.training.swim.IndoorSwim;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;
    
    private String description;
    
    private String picture;
    
    private String profession;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @JsonBackReference
    List<IndoorSwim> indoorSwims;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @JsonBackReference
    List<Run> runs;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @JsonBackReference
    List<Exercise> exercises;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="user")
    @JsonBackReference
    private Health health;
    
    public String getDisplayName() {
    	return this.name;
    }

}
