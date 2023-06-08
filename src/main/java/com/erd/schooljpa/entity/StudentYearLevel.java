package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="StudentYearLevel")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "student_year_level"
)
public class StudentYearLevel {

    @EmbeddedId
    private StudentYearLevelId id;

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
    @MapsId("studentYearLevelId")
    @JoinColumn(
            name = "level_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "student_year_level_id_fk"
            )
    )
    private YearLevel yearLevel;

    @ManyToOne
    @MapsId("schoolYearId")
    @JoinColumn(
            name = "year_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "school_year_id_fk"
            )
    )
    private SchoolYear schoolYear;

    @Column(
            name = "score"
    )
    private Integer score;

}
