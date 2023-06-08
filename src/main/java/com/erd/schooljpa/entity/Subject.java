package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name = "Subject"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "subject"
)
public class Subject {

    @Id
    @SequenceGenerator(
            name = "subject_sequence",
            sequenceName = "subject_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "subject_sequence"
    )
    @Column(
            updatable = false
    )
    private Long id;

    @Column(
            name = "subject_name"
    )
    private String subjectName;

    @OneToMany(
            mappedBy = "subject",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    private List<Class> classes = new ArrayList<>();

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }

    )
    @JoinColumn(
            name = "department_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="subject_department_id_fk"
            )
    )
    private Department department;

    public void addClass(Class aclass){
        if(!classes.contains(aclass)){
            classes.add(aclass);
        }
    }

    public void removeClass(Class aclass){
        classes.remove(aclass);
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }
}
