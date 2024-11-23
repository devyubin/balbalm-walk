package com.devocean.Balbalm.dummy.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDummyPlaceDomain {
    private String name;
    private String category;
    private List<String> pictures;
    private double distance;
    private String address;
}
