package com.moop.kmareviews.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;


    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm dd/mm/yyyy")
    private LocalDateTime sendTime;
}
