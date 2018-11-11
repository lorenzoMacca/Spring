package com.training.entities.training.swim;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class SwimTrainingPattern {

    @Id
    @GeneratedValue
    Long id;

    @NotNull
    String pattern;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "pattern")
    @JsonBackReference
    List<IndoorSwim> indoorSwims;
}
