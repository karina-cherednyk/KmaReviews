package com.moop.kmareviews.db_side.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id","name"})
@ToString(of = {"id"})
@RequiredArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    @NonNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Faculty faculty;

}
