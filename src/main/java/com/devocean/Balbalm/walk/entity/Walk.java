package com.devocean.Balbalm.walk.entity;

import com.devocean.Balbalm.global.config.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "walk")
public class Walk extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "walk_id")
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "walk_time")
    private long time;

    @Column(name = "distance")
    private double distance;

    @Column(name = "kcal")
    private int kcal;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;
}
