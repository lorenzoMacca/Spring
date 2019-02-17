package com.training.entities.training.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @JsonBackReference
    List<IndoorSwim> indoorSwims;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @JsonBackReference
    List<Run> runs;
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    @JsonBackReference
    List<Exercise> exercises;

}
