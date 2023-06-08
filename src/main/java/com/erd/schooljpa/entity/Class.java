package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name = "Class"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "class"
)
public class Class {

    @Id
    @SequenceGenerator(
            name = "class_sequence",
            sequenceName = "class_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "class_sequence"
    )
    private Long id;
    @Column(
            name = "name"
    )
    private String name;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "subject_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "class_subject_id"
            )
    )
    private Subject subject;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "class_teacher_id_fk"
            )
    )
    private Teacher teacher;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "term_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "class_term_id_fk"
            )
    )
    private Term term;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "start_period__id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "start_period_id_fk"
            )
    )
    private Period period;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "end_period__id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "end_period_id_fk"
            )
    )
    private Period period1;



    @OneToMany(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY,
            mappedBy = "aClass"
    )
    private List<StudentClass> studentClass = new ArrayList<>();




    public void addStudentClass(StudentClass studentClass1){
        if(!studentClass.contains(studentClass1)){
            studentClass.add(studentClass1);
        }
    }

    public void removeStudentClass(StudentClass studentClass1){
        studentClass.remove(studentClass1);
    }

    public Class(String name) {
        this.name = name;
    }
}
