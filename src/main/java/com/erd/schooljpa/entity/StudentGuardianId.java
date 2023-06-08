package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentGuardianId implements Serializable {

    @Column(
            name = "student_id"
    )
    private Long studentId;

    @Column(
            name = "guardian_type_id"
    )
    private Long guardianTypeId;

    @Column(
            name = "guardian_id"
    )
    private Long guardianId;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGuardianId that = (StudentGuardianId) o;
        return Objects.equals(studentId, that.studentId) && Objects.equals(guardianId, that.guardianId) && Objects.equals(guardianTypeId, that.guardianTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, guardianId, guardianTypeId);
    }
}
