package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Entity(
        name = "Guardian"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "guardian"
)
public class Guardian {

    @Id
    @SequenceGenerator(
            name = "guardian_sequence",
            sequenceName = "guardian_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guardian_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "given_name"
    )
    private String givenName;

    @Column(
            name = "surname"
    )
    private String surname;

    @Column(
            name = "email"
    )
    private String email;

    @Column(
            name = "phone_number"
    )
    private String phoneNumber;

    @OneToMany(
            cascade = {
                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
            },
            fetch = FetchType.LAZY,
            mappedBy = "guardian"
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

    public Guardian(String givenName, String surname, String email, String phoneNumber) {
        this.givenName = givenName;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
