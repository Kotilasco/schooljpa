package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name = "GuardianType"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "guardian_type"
)
public class GuardianType {

    @Id
    @SequenceGenerator(
            name = "guardian_type_sequence",
            sequenceName = "guardian_type_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guardian_type_sequence"
    )
    private Long id;
    private String name;

    @OneToMany(
            cascade = {
                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
            },
            fetch = FetchType.LAZY,
            mappedBy = "guardianType"
    )
    private List<StudentGuardian> studentGuardians = new ArrayList<>();

    public void addStudentGuardian(StudentGuardian studentGuardian){
        if(!studentGuardians.contains(studentGuardian)){
            studentGuardians.add(studentGuardian);
        }
    }

    public void removeStudentGuardian(StudentGuardian studentGuardian){
        studentGuardians.remove(studentGuardian);
    }

    public GuardianType(String name) {
        this.name = name;
    }
}
