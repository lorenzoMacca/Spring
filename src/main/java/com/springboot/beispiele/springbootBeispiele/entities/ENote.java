package com.springboot.beispiele.springbootBeispiele.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class ENote {

    @Id
    @GeneratedValue
    private Long id;

    private Integer note;
}
