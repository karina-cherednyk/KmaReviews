package com.moop.kmareviews.entities;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Brief.class)
    private Long id;

    @JsonView(Views.Brief.class)
    private String name;

    @ManyToMany(mappedBy = "possibleCourses", fetch = FetchType.EAGER)
    @JsonView(Views.FullCourse.class)
    private Set<Teacher> possibleTeachers = new HashSet<>();
}
