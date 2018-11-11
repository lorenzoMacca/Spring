package com.training.entities.training.swim;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.google.common.primitives.UnsignedInteger;
import com.training.core.training.swim.ISwim;
import com.training.core.training.swim.PoolLength;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
}
