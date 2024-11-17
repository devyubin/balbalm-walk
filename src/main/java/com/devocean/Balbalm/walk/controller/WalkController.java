package com.devocean.Balbalm.walk.controller;

import com.devocean.Balbalm.global.exception.CommonResponse;
import com.devocean.Balbalm.walk.usecase.GetWalkRankUseCase;
import com.devocean.Balbalm.walk.usecase.SaveWalkUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/walk")
@RequiredArgsConstructor
public class WalkController {
    private final SaveWalkUseCase saveWalkUseCase;
    private final GetWalkRankUseCase getWalkRankUseCase;

    @PostMapping
    public CommonResponse<SaveWalkUseCase.Result> saveWalk(@RequestBody SaveWalkUseCase.Command command) {
        return new CommonResponse<>(saveWalkUseCase.execute(command));
    }

    @GetMapping("/rank")
    public CommonResponse<GetWalkRankUseCase.Result> getWalkRank() {
        return new CommonResponse<>(getWalkRankUseCase.execute(null));
    }
}
