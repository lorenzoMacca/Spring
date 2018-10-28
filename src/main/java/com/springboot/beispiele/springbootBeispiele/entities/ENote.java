package com.springboot.beispiele.springbootBeispiele.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ENote {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private Integer note;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private EStudent student;

    public ENote(Integer note) {
        this.note = note;
    }

    public ENote(Integer note, EStudent student) {
        this.note = note;
        this.student = student;
    }
}
