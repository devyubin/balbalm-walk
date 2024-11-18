package com.devocean.Balbalm.walk.controller;

import com.devocean.Balbalm.global.exception.CommonResponse;
import com.devocean.Balbalm.walk.usecase.GetWalkRankUseCase;
import com.devocean.Balbalm.walk.usecase.SaveWalkUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/walk")
@RequiredArgsConstructor
@Tag(name = "Walk", description = "걷기 정보 관리 API")
public class WalkController {
    private final SaveWalkUseCase saveWalkUseCase;
    private final GetWalkRankUseCase getWalkRankUseCase;

    @Operation(summary = "걷기 정보 저장", description = "걷기 정보를 저장합니다.")
    @PostMapping
    public CommonResponse<SaveWalkUseCase.Result> saveWalk(@RequestHeader("Authorization") String token, @RequestBody SaveWalkUseCase.Command command) {
        command.setToken(token.substring(7));
        return new CommonResponse<>(saveWalkUseCase.execute(command));
    }

    @Operation(summary = "걷기 순위 조회", description = "걷기 순위를 조회합니다.")
    @GetMapping("/rank")
    public CommonResponse<GetWalkRankUseCase.Result> getWalkRank() {
        return new CommonResponse<>(getWalkRankUseCase.execute(null));
    }
}
