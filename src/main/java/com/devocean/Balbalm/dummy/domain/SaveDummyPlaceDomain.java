package com.devocean.Balbalm.dummy.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SaveDummyPlaceDomain {
    private String name;
    private String category;
    private String pictures;
    private double distance;
    private String address;
}
