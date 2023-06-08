package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(
        name = "YearLevel"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name ="year_level"
)
public class YearLevel {

    @Id
    @SequenceGenerator(
            name = "year_level_sequence",
            sequenceName = "year_level_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "year_level_sequence"
    )
    private Long id;

    @Column(
            name = "level_name"
    )
    private String levelName;

    @Column(
            name = "level_order"
    )
    private Integer levelOrder;

    @OneToMany(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY,
            mappedBy = "yearLevel"
    )
    private List<StudentYearLevel> studentYearLevels = new ArrayList<>();


    public YearLevel(String levelName, Integer levelOrder) {
        this.levelName = levelName;
        this.levelOrder = levelOrder;
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
