package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name = "Student"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "student"
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "given_name"
    )
    private String givenName;
    @Column(
            name = "middle_name"
    )
    private String middleName;
    @Column(
            name = "surname"
    )
    private String surname;

    @Column(
            name = "date_of_birth"
    )
    private LocalDate dateOfBirth;

    @Column(
            name = "gender"
    )
    private String gender;

    @Column(
            name="enrolment_date"
    )
    private LocalDate enrolmentDate;

    @OneToMany(
            cascade = {
                    CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH
            },
            fetch = FetchType.LAZY,
            mappedBy = "student"
    )
    private List<StudentGuardian> studentGuardians = new ArrayList<>();

    @OneToMany(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY,
            mappedBy = "student"
    )
    private List<StudentClass> studentClass = new ArrayList<>();

    @OneToMany(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY,
            mappedBy = "student"
    )
    private List<StudentYearLevel> studentYearLevels = new ArrayList<>();


    public void addLevel(StudentYearLevel studentYearLevel){
        if(!studentYearLevels.contains(studentYearLevel)){
            studentYearLevels.add(studentYearLevel);
        }
    }

    public void removeLevel(StudentYearLevel studentYearLevel){
        studentYearLevels.remove(studentYearLevel);
    }

    public void addStudentClass(StudentClass studentClass1){
        if(!studentClass.contains(studentClass1)){
            studentClass.add(studentClass1);
        }
    }

    public void removeStudentClass(StudentClass studentClass1){
        studentClass.remove(studentClass1);
    }

    public void addStudentGuardian(StudentGuardian studentGuardian){
        if(!studentGuardians.contains(studentGuardian)){
            studentGuardians.add(studentGuardian);
        }
    }

    public void removeStudentGuardian(StudentGuardian studentGuardian){
        studentGuardians.remove(studentGuardian);
    }

    public Student(String givenName, String middleName, String surname, LocalDate dateOfBirth, String gender, LocalDate enrolmentDate) {
        this.givenName = givenName;
        this.middleName = middleName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.enrolmentDate = enrolmentDate;
    }
}
