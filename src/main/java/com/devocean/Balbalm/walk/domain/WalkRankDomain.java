package com.devocean.Balbalm.walk.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalkRankDomain {
    private String userId;
    private String profileImageUrl;
    private String nickName;
    private long totalDistance;
}
