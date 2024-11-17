package com.devocean.Balbalm.walk.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WalkRankUserDomain {
    private String userId;
    private String profileImageUrl;
    private String nickName;
    private int totalDistance;
}
