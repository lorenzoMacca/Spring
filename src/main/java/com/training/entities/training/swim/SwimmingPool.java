package com.training.entities.training.swim;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SwimmingPool {

    @Id
    @GeneratedValue
    @NotNull
    Long id;

    @NotNull
    String name;

    @NotNull
    String address;

    URL webpage;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "swimmingPool")
    List<IndoorSwim> indoorSwims;


}
