package com.moop.kmareviews.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Brief.class)
    private Long id;
    @Column(unique=true)
    @JsonView(Views.Brief.class)
    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "possible_courses",
            joinColumns = {@JoinColumn(name = "teacher_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    @JsonView(Views.FullTeacher.class)
    private Set<Course> possibleCourses = new HashSet<>();

    public void addPossibleCourse(Course course){
        possibleCourses.add(course);
        course.getPossibleTeachers().add(this);
    }
}
