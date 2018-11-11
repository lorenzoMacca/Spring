package com.training.entities.training.swim;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.training.core.training.swim.ISwimmingPool;
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
public class SwimmingPlace implements ISwimmingPool {

    @Id
    @GeneratedValue
    @NotNull
    Long id;

    @NotNull
    String name;

    @NotNull
    String address;

    String webpage;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "swimmingPlace")
    @JsonBackReference
    List<IndoorSwim> indoorSwims;


}
