package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name = "Department"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name="department"
)
public class Department {

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
            name = "department_name"
    )
    private String departmentName;


    @OneToMany(
            mappedBy = "department",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Subject> subjects = new ArrayList<>();

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public void addSubject(Subject subject){
        if(!subjects.contains(subject)){
            subjects.add(subject);
        }
    }

    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }



}
