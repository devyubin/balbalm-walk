package com.devocean.Balbalm.walk.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalkDomain {
    private String userId;
    private long time;
    private double distance;
    private int kcal;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
