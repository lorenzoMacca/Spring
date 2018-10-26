package com.springboot.beispiele.springbootBeispiele.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
    private List<ENote> noten;

    public EStudent(@NotNull String name) {
        this.name = name;
    }

    public EStudent(@NotNull String name, List<ENote> noten) {
        this.name = name;
        this.noten = noten;
    }
}

