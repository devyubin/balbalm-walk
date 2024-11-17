package com.devocean.Balbalm.walk.usecase;

import com.devocean.Balbalm.global.UseCase;
import com.devocean.Balbalm.walk.dataprovider.WalkDataProvider;
import com.devocean.Balbalm.walk.domain.WalkDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetWalkRankUseCase implements UseCase<GetWalkRankUseCase.Command, GetWalkRankUseCase.Result> {
    private final WalkDataProvider walkDataProvider;
    private static final int TOP_RANK_NUMBER = 3;

    @Override
    public Result execute(Command input) {

        LocalDate today = LocalDate.now();
        LocalDate startDate = today.withDayOfMonth(1);
        LocalDate endDate = today.withDayOfMonth(today.lengthOfMonth());

        List<WalkDomain> walkRank = walkDataProvider.getWalkRank(startDate, endDate);
        if (ObjectUtils.isEmpty(walkRank)) {
            return new Result();
        }

        List<Map.Entry<String, Double>> rankUsers = walkRank.stream()
                .collect(Collectors.groupingBy(
                        WalkDomain::getUserId,
                        Collectors.summingDouble(WalkDomain::getDistance)
                ))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()))
                .limit(TOP_RANK_NUMBER)
                .toList();

        List<Result.Rank> rankList = rankUsers.stream()
                .map(entry -> {
                    String userId = entry.getKey();
                    long totalDistance = entry.getValue().longValue();
                    String profileImageUrl = "";
                    String nickName = "";

                    return Result.Rank.builder()
                            .userId(userId)
                            .totalDistance(totalDistance)
                            .profileImageUrl(profileImageUrl)
                            .nickName(nickName)
                            .build();
                }).toList();

        return Result.builder()
                .rankList(rankList)
                .build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Command implements Serializable, UseCase.Command {

        @Serial
        private static final long serialVersionUID = 7945692511272396990L;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result implements Serializable, UseCase.Result {

        @Serial
        private static final long serialVersionUID = -2279484834715742375L;
        
        private List<Rank> rankList;

        @Getter
        @Setter
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Rank {
            private String userId;
            private long totalDistance;
            private String profileImageUrl;
            private String nickName;
        }
    }
}