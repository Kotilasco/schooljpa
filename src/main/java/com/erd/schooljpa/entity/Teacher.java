package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name="Teacher"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "teacher"
)
public class Teacher {

    @Id
    @SequenceGenerator(
            name = "teacher_sequence",
            sequenceName = "teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
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
            name = "gender"
    )
    private String gender;

    @Column(
            name = "email"
    )
    private String email;


    @Column(
            name = "phone_number"
    )
    private String phoneNumber;


    @OneToMany(
            mappedBy = "teacher",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH
            }
    )
    private List<Class> classes = new ArrayList<>();


    public void addClass(Class aclass){
        if(!classes.contains(aclass)){
            classes.add(aclass);
        }
    }

    public void removeClass(Class aclass){
        classes.remove(aclass);
    }
}
