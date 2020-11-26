package com.moop.kmareviews.db_side.entities;

import lombok.*;

import javax.persistence.*;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(of = {"id","name"})
@ToString(of = {"id"})
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    @NonNull
    private String name;

}
