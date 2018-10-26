package com.springboot.beispiele.springbootBeispiele.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class EStudent {

    @Id
    @GeneratedValue
    @NotNull
    private Long id;

    @NotNull
    private String name;

    public EStudent(@NotNull String name) {
        this.name = name;
    }
}

