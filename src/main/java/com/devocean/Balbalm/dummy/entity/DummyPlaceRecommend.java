package com.devocean.Balbalm.dummy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dummy_place_recommend")
@NoArgsConstructor
@AllArgsConstructor
public class DummyPlaceRecommend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dummy_place_recommend_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    @Column(name = "pictures")
    private String pictures;

    @Column(name = "distance")
    private double distance;

    @Column(name = "address")
    private String address;
}
