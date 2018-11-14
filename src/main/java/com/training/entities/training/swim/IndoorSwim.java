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
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IndoorSwim{

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotNull
    private Date date;

    private String description;

    @NotNull
    private Double duration;

    @NotNull
    private Integer numberOfLaps;

    @NotNull
    private PoolLength poolLength;

    @NotNull
    @ManyToOne
    @JsonBackReference
    private SwimmingPlace swimmingPlace;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_swim",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "indoor_swim_id")}
    )
    @JsonManagedReference
    private List<User> users;

    @NotNull
    @ManyToOne
    @JsonManagedReference
    private SwimTrainingPattern pattern;
    
    @NotNull
    @ManyToOne
    @JsonBackReference
    Session session;

}
