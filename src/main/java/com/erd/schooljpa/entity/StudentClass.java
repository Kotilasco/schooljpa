package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(
        name = "StudentClass"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "student_class"
)
public class StudentClass {

    @EmbeddedId
    private StudentClassId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id"
    )
    private Student student;

    @ManyToOne
    @MapsId("classId")
    @JoinColumn(
            name = "class_id",
            referencedColumnName = "id"
    )
    private Class aClass;
}
