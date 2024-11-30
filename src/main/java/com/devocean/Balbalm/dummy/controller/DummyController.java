package com.devocean.Balbalm.dummy.controller;

import com.devocean.Balbalm.dummy.usecase.GetDummyPlaceUseCase;
import com.devocean.Balbalm.dummy.usecase.SaveDummyPlaceUseCase;
import com.devocean.Balbalm.global.exception.CommonResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Dummy", description = "더미용 API")
@RestController
@RequestMapping("/api/dummy")
@RequiredArgsConstructor
public class DummyController {
    private final SaveDummyPlaceUseCase saveDummyPlaceUseCase;
    private final GetDummyPlaceUseCase getDummyPlaceUseCase;

    @Operation(summary = "추천 장소 저장(관리자용 API)")
    @PostMapping("/place-recommend")
    public CommonResponse<SaveDummyPlaceUseCase.Result> saveDummyPlaceRecommend(@RequestBody SaveDummyPlaceUseCase.Command command) {
        return new CommonResponse<>(saveDummyPlaceUseCase.execute(command));
    }

    @Operation(summary = "추천 장소 조회")
    @GetMapping("/place-recommend")
    public CommonResponse<GetDummyPlaceUseCase.Result> getDummyPlaceRecommend() {
        return new CommonResponse<>(getDummyPlaceUseCase.execute(null));
    }
}
