package com.devocean.Balbalm.walk.usecase;

import com.devocean.Balbalm.global.UseCase;
import com.devocean.Balbalm.walk.dataprovider.WalkDataProvider;
import com.devocean.Balbalm.walk.dataprovider.UserDataProvider;
import com.devocean.Balbalm.walk.domain.UserDomain;
import com.devocean.Balbalm.walk.domain.WalkDomain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetWalkRankUseCase implements UseCase<GetWalkRankUseCase.Command, GetWalkRankUseCase.Result> {
    private final WalkDataProvider walkDataProvider;
    private final UserDataProvider userDataProvider;

    @Override
    public Result execute(Command input) {

        LocalDateTime now = LocalDateTime.now();
        YearMonth currentYearMonth = YearMonth.of(now.getYear(), now.getMonth());
        int lastDayOfMonth = currentYearMonth.lengthOfMonth();

        LocalDateTime startDate = LocalDateTime.of(now.getYear(), now.getMonth(), 1, 0, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(now.getYear(), now.getMonth(), lastDayOfMonth, 23, 59, 59);

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
                .toList();

        List<Result.Rank> rankList = rankUsers.stream()
                .map(entry -> {
                    String userId = entry.getKey();
                    long totalDistance = entry.getValue().longValue();

                    UserDomain userDomain = userDataProvider.getUserInfo(userId);
                    return Result.Rank.builder()
                            .userId(userId)
                            .totalDistance(totalDistance)
                            .profileImageUrl(userDomain.getProfileImageUrl())
                            .nickName(userDomain.getNickName())
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