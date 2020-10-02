package com.moop.kmareviews.entities;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String teacher;
    private String course;
    private LocalDateTime sendTime;
}
