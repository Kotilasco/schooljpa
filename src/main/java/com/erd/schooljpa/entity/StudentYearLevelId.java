package com.erd.schooljpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentYearLevelId implements Serializable {

    @Column(
            name = "studentId"
    )
    private Long studentId;

    @Column(
            name = "level_id"
    )
    private Long studentYearLevelId;

    @Column(
            name = "year_id"
    )
    private Long schoolYearId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentYearLevelId that = (StudentYearLevelId) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(studentYearLevelId, that.studentYearLevelId) && Objects.equals(schoolYearId, that.schoolYearId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentYearLevelId, schoolYearId);
    }
}
