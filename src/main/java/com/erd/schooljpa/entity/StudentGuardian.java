package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "StudentGuardian")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "student_guardian"
)
public class StudentGuardian {


    @EmbeddedId
    private StudentGuardianId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_id_fk"
            )
    )
    private Student student;

    @ManyToOne
    @MapsId("guardianTypeId")
    @JoinColumn(
            name = "guardian_type_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "guardian_type__id_fk"
            )
    )
    private GuardianType guardianType;

    @ManyToOne
    @MapsId("guardianId")
    @JoinColumn(
            name = "guardian_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "guardian_id_fk"
            )
    )
    private Guardian guardian;
}
