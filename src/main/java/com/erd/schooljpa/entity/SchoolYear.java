package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name = "SchoolYear"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "school_year"
)
public class SchoolYear {

    @Id
    @SequenceGenerator(
            name = "school_year_sequence",
            sequenceName = "school_year_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "school_year_sequence"
    )
    private Long id;

    private String yearName;

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
            mappedBy = "schoolYear"
    )
    private List<StudentYearLevel> studentYearLevels = new ArrayList<>();

    @OneToMany(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY,
            mappedBy = "schoolYear"
    )
    private List<Term> terms = new ArrayList<>();

    public void addTerm(Term term){
        if(!terms.contains(term)){
            terms.add(term);
        }
    }

    public void removeTerm(Term term){
        terms.remove(term);
    }


    public SchoolYear(String yearName, LocalDate startDate, LocalDate endDate) {
        this.yearName = yearName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addLevel(StudentYearLevel studentYearLevel){
        if(!studentYearLevels.contains(studentYearLevel)){
            studentYearLevels.add(studentYearLevel);
        }
    }

    public void removeLevel(StudentYearLevel studentYearLevel){
        studentYearLevels.remove(studentYearLevel);
    }
}
