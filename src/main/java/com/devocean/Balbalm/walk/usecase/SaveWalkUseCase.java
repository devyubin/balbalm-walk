package com.devocean.Balbalm.walk.usecase;

import com.devocean.Balbalm.global.UseCase;
import com.devocean.Balbalm.walk.dataprovider.WalkDataProvider;
import com.devocean.Balbalm.walk.domain.WalkDomain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class SaveWalkUseCase implements UseCase<SaveWalkUseCase.Command, SaveWalkUseCase.Result> {

    private final WalkDataProvider walkDataProvider;

    @Override
    public Result execute(Command input) {
        // TODO Mission 구독 취소 API 호출

        walkDataProvider.saveWalk(
                WalkDomain.builder()
                        .time(input.getTime())
                        .distance(input.getDistance())
                        .kcal(input.getKcal())
                        .startDateTime(input.getStartDateTime())
                        .endDateTime(input.getEndDateTime())
                        .build()
        );
        return new Result();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Command implements Serializable, UseCase.Command {

        @Serial
        private static final long serialVersionUID = 7945692511272396990L;

        private String userId;
        private long time;
        private float distance;
        private int kcal;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime startDateTime;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime endDateTime;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Result implements Serializable, UseCase.Result {

        @Serial
        private static final long serialVersionUID = -2279484834715742375L;
    }
}
