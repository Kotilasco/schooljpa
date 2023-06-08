package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name = "ClassroomTypes"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(
        name = "classroom_types"
)
public class ClassroomTypes {

    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private Long id;

    @Column(
            name = "name"
    )
    private String name;

    @OneToMany(
            mappedBy = "classroomTypes",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Classroom> classrooms = new ArrayList<>();

    public void addClassroom(Classroom classroom){
        if(!classrooms.contains(classroom)){
            classrooms.add(classroom);
        }
    }

    public void removeClassroom(Classroom classroom){
        classrooms.remove(classroom);
    }

    public ClassroomTypes(String name) {
        this.name = name;
    }
}
