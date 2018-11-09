package com.training.entities.training.swim;

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
public class IndoorSwim {

    @Id
    @GeneratedValue
    @NotNull
    Long id;

    @NotNull
    Date date;

    String description;

    @NotNull
    @ManyToOne
    SwimmingPool swimmingPool;
}
