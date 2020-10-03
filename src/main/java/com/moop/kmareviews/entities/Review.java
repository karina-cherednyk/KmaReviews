package com.moop.kmareviews.entities;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id"})
public class Review{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(Views.Brief.class)
    private Long id;

    @JsonView(Views.Brief.class)
    private String text;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonView(Views.Full.class)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonView(Views.Full.class)
    private Course course;

    @Column(updatable = false)
    @JsonView(Views.Full.class)
    private LocalDateTime sendTime;
}
