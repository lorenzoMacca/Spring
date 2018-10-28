package com.springboot.beispiele.springbootBeispiele.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @NonNull
    private Integer age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
    @JsonManagedReference
    private List<ENote> noten;

    public EStudent(@NotNull String name) {
        this.name = name;
    }

    public EStudent(@NotNull String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void add(ENote eNote){
        this.noten.add(eNote);
    }
}

