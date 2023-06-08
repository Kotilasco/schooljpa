package com.erd.schooljpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Classroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "classroom"
)
public class Classroom {

    @Id
    @SequenceGenerator(
            name = "classroom_sequence",
            sequenceName = "classroom_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "classroom_sequence"
    )
    private Long id;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "room_type",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "classroom_type_fk"
            )
    )
    private ClassroomTypes classroomTypes;

    @Column(
            name = "room_name"
    )
    private String roomName;

    @Column(
            name = "capacity"
    )
    private Integer capacity;

    public Classroom(String roomName, Integer capacity) {
        this.roomName = roomName;
        this.capacity = capacity;
    }
}
