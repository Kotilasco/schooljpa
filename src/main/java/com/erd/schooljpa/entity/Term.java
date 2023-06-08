package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name = "Term"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "term"
)
public class Term {

    @Id
    @SequenceGenerator(
            name = "term_sequence",
            sequenceName = "term_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "term_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            }
    )
    @JoinColumn(
            name = "year_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "school_term_fk"
            )
    )
    private SchoolYear schoolYear;

    private Integer termNumber;

    @Column(
            name = "start_date"
    )
    private LocalDate startDate;

    @Column(
            name = "end_date"
    )
    private LocalDate endDate;

    @OneToMany(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY,
            mappedBy = "term"
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
