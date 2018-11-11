package com.training.entities.training.swim;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.training.core.training.swim.ISwim;
import com.training.core.training.swim.PoolLength;
import com.training.entities.training.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndoorSwim implements ISwim {

    @Id
    @GeneratedValue
    @NotNull
    Long id;

    @NotNull
    Date date;

    String description;

    @NotNull
    Double duration;

    @NotNull
    Integer numberOfLaps;

    @NotNull
    PoolLength poolLength;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    SwimmingPlace swimmingPlace;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.MERGE})
    @JoinTable(name = "user_swim",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "indoor_swim_id")}
    )
    @JsonManagedReference
    List<User> users;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    SwimTrainingPattern pattern;

}
